package com.paymentrecommendation.factory;

import com.paymentrecommendation.recommender_strategies.RelevanceRecommendation;
import com.paymentrecommendation.repository.IBusinessRelevanceOrdering;
import com.paymentrecommendation.repository.IBusinessUseCase;

public class PaymentRecommenderFactory {
    public RelevanceRecommendation defaultRecommender(IBusinessUseCase businessUseCase, IBusinessRelevanceOrdering businessRelevanceOrdering) {
        return new RelevanceRecommendation(businessUseCase, businessRelevanceOrdering);
    }
}
