package com.intershop.adapter.search.bo.sparque.internal;

import com.google.inject.multibindings.Multibinder;
import com.intershop.beehive.core.capi.naming.AbstractNamingModule;
import com.intershop.component.product.capi.search.ProductBOSearchService;

public class AcBoSearchSparqueModule extends AbstractNamingModule
{
    @Override
    protected void configure()
    {
        Multibinder<ProductBOSearchService> mb = Multibinder.newSetBinder(binder(), ProductBOSearchService.class);
        mb.addBinding().to(SparqueProductBOSearchService.class);
    }


}