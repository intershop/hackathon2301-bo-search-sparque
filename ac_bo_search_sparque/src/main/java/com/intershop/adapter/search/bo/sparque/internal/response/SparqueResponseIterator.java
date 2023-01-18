package com.intershop.adapter.search.bo.sparque.internal.response;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.intershop.component.search.capi.common.AbstractPageBufferIteratorImpl;

public class SparqueResponseIterator extends AbstractPageBufferIteratorImpl<ProductItem>
{

    private static final long serialVersionUID = 1L;
    private Integer elementCount;
    private WebTarget webTarget;

    public SparqueResponseIterator(ResultsResponse response, Integer elementCount, WebTarget webTarget)
    {
        super(response.getItems());
        //TODO get the total for elementCount
        this.elementCount = elementCount;
        this.webTarget = webTarget;
    }

    @Override
    public int getElementCount()
    {
        return elementCount;
    }

    @Override
    protected List<ProductItem> fetchNewPage(int elementPosition)
    {
        ResultsResponse sparqueResponse = webTarget.queryParam("offset", elementPosition)
                                                   .queryParam("count", getPageSize())
                                                   .request(MediaType.APPLICATION_JSON)
                                                   .get(ResultsResponse.class);
        return sparqueResponse.getItems();
    }

}
