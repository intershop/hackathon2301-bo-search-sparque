package com.intershop.adapter.search.bo.sparque.internal;
import java.util.stream.Collectors;

import com.intershop.component.foundation.capi.search.SearchExpression;
import com.intershop.component.foundation.capi.search.SearchExpressionPhrase;
import com.intershop.component.foundation.capi.search.SearchExpressionValuePhrase;

public class QueryConverter
{

    static final String AND = " AND ";
    static final String OR = " OR ";

    String convertSearchExpression(SearchExpression query)
    {
        if (query == null || query.isEmpty())
        {
            return "*";
        }

        String operatorStr = " "; //TODO handle AND OR
        return query.getPhrases()
                        .stream()
                        .map(this::getPhraseAsString)
                        .collect(Collectors.joining(operatorStr));
    }

    private String getPhraseAsString(SearchExpressionPhrase phrase)
    {
        StringBuilder expressionStringBuilder = new StringBuilder();
        String value = "";
        if (phrase instanceof SearchExpressionValuePhrase)
        {
            value = ((SearchExpressionValuePhrase)phrase).getValue();
        }
        switch(phrase.getType())
        {
            //TODO how to handle
            case SearchExpressionPhrase.TYPE_FUZZYMATCH:
            case SearchExpressionPhrase.TYPE_EXACTMATCH:
            case SearchExpressionPhrase.TYPE_WILDCARDMATCH:
            case SearchExpressionPhrase.TYPE_EXCLUSION:
            default:
                expressionStringBuilder.
                                append(value);

        }

        return expressionStringBuilder.toString();
    }
}
