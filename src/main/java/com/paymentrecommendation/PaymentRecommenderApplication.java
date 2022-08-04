package com.paymentrecommendation;

import com.paymentrecommendation.manager.PaymentManager;

public class PaymentRecommenderApplication {

	public static void main(String[] args) {
		PaymentManager<Object, Object> paymentManager = new PaymentManager<>();
		paymentManager.recommendPaymentInstruments();
	}
}
