package com.payitezy;

public enum APIKeys {

	
	DATAYUGEKEYS("aZciW2VAYLi3N6NkSUA3qRSBnyGt1A0A"),
	FLIPKARTAFFILIATEID("infoarthv"),
	FLIPKARTAFFILIATETOKEN("73b0831aba9a49b7a38dba92c3b4faa2"),
	SNAPDEALAFFILIATEID("83698"),
	SNAPDEALAFFILIATETOKEN("fb407dbf496b93dab3833e2163c269"),
	SMSACHARYAUID("7061796974657a79"),
	SMSACHARYAAPIVERSION("4"),
	SMSACHARYAPIN("72e6182cd2dabe11c4676caf24a3ddb1");
	  private String apiKey;

	  APIKeys(final String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSequenceName() {
        return apiKey;
    }
}
