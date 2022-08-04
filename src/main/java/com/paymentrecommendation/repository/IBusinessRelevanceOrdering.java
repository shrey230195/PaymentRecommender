package com.paymentrecommendation.repository;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.models.BusinessRelevanceOrdering;
import com.paymentrecommendation.models.BusinessUseCase;

public interface IBusinessRelevanceOrdering {
  void createBusinessRelevance(BusinessRelevanceOrdering ordering);

  BusinessRelevanceOrdering getBusinessRelevance(LineOfBusiness lineOfBusiness);
}