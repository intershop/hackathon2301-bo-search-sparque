package com.intershop.adapter.search.bo.sparque.internal;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.intershop.adapter.search.bo.sparque.internal.response.ProductItem;
import com.intershop.adapter.search.bo.sparque.internal.response.ResultsResponse;
import com.intershop.adapter.search.bo.sparque.internal.response.SparqueResponseIterator;
import com.intershop.adapter.search.bo.sparque.internal.response.StatisticsResponse;
import com.intershop.beehive.core.capi.paging.PageableIterator;
import com.intershop.beehive.core.capi.request.Request;
import com.intershop.beehive.core.capi.util.UUIDGenerator;
import com.intershop.beehive.core.internal.search.MappingPageable;
import com.intershop.common.webinterface.capi.WebTargetFactory;
import com.intershop.component.application.capi.CurrentApplicationBOProvider;
import com.intershop.component.product.capi.ProductBO;
import com.intershop.component.product.capi.ProductBORepository;
import com.intershop.component.product.capi.ProductBORepositoryExtension;
import com.intershop.component.product.capi.search.ProductBOSearchService;
import com.intershop.component.product.capi.search.SimpleSearchParameters;
import com.intershop.component.search.capi.common.SearchType;

public class SparqueProductBOSearchService implements ProductBOSearchService
{

    public static final String SPARQUE_BO_SEARCH = "sparque-bo-search";

    @Inject
    WebTargetFactory webTargetFactory;
    @Inject
    CurrentApplicationBOProvider appBOProvider;
    @Inject
    UUIDGenerator uuidGenerator;
    @Inject
    Provider<Request> currentRequest;

    // access current request
    // currentRequest.get()...

    @Override
    public String getServiceID()
    {
        return SPARQUE_BO_SEARCH;
    }

    @Override
    public boolean isSupported(SearchType searchType)
    {
        return SearchType.SIMPLE == searchType;
    }

    @Override
    public PageableIterator<ProductBO> getProductBOs(Map<String, Object> searchParameters, SearchType searchType,
                    int pageSize)
    {
        if (searchType == SearchType.SIMPLE)
        {
            SimpleSearchParameters simpleSearchParams = new SimpleSearchParameters(searchParameters);
            return executeSparqueSearch(simpleSearchParams, pageSize);

        }

        return null;
    }

    private PageableIterator<ProductBO> executeSparqueSearch(SimpleSearchParameters simpleSearchParams, int pageSize)
    {
        String searchStr = new QueryConverter().convertSearchExpression(simpleSearchParams.getNameOrID());

        WebTarget webTarget = webTargetFactory.createWebTarget(
                        "https://rest.spinque.com/4/sandboxsparque/api/HckTn2301/e/bo-simple-search/p/nameOrId/")
                                              .path(searchStr);

        WebTarget webTargetResults = webTarget.path("results");

        WebTarget webTargetStats = webTarget.path("statistics");
        ;

        ResultsResponse response = webTargetResults.queryParam("count", pageSize)
                                                   .request(MediaType.APPLICATION_JSON)
                                                   .get(ResultsResponse.class);
        StatisticsResponse statsResponse = webTargetStats.queryParam("count", pageSize)
                                                         .request(MediaType.APPLICATION_JSON)
                                                         .get(StatisticsResponse.class);
        response.getCount();

        ProductBORepository productBORepository = appBOProvider.get()
                                                               .getGuaranteedRepository(
                                                                               ProductBORepositoryExtension.EXTENSION_ID);
        SparqueResponseIterator resultItems = new SparqueResponseIterator(response, statsResponse.getTotal(),
                        webTargetResults);
        resultItems.setID(uuidGenerator.createUUIDString());
        resultItems.setPageSize(pageSize);
        return new MappingPageable(resultItems, item -> {
            String sku = ((ProductItem)item).getTuple().get(0).getAttributes().getSku();
            return productBORepository.getProductBOBySKU(sku);
        });
    }
}
