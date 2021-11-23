package com.aguasra.backend.apirest.auth;

public class JwtConfig {

	public static final String KEY_SECRET = "clave.secreta.123456789";
	
	public static final String RSA_PRIVATE= "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpAIBAAKCAQEAp3SLFxzUXT3gHYLL/f9Qa+2HYOjMsIY6AWz4oWTR4WZy1JHw\r\n" + 
			"tMGSq4kjb1r7Gqo4qYBdKHrAm/aS20pGPCOWESB6DrJRVo5w6Wyi6MoYSmXGikJC\r\n" + 
			"YchW6MSjjkgxuOMOQfwdy5K3IuoltT3qERvHgEAcSs/VfPgeh8JuiU+9FuFwD2z2\r\n" + 
			"5kxkLK1Ax6IEVK41ypJjhJMTDtoPqJ9HrD7ufctsDSmbqAJAvN6sEoeuH0XXdzpV\r\n" + 
			"e+k35nxY4hq2fF48SpW/759Kq8pNWbs9fnJB/+1Hoh3xl+6ZqBz+XEwYiOBgorz1\r\n" + 
			"RmuZWamVl7VYTWJKcwZXDIhXA9ArGmS4WU7ffQIDAQABAoIBAEMukaL7MQQbj++n\r\n" + 
			"CxpjNSunxzmNDJoBsAHkazetEDsi9AzuZCjQxHxHb8z8LmP7SPJQCo/z95Ra735F\r\n" + 
			"JTp5eHp0kiOVTOayDQDJUe6dLfOjM21Cugkq7BtE0O2Db1di2NSGRpnmycybLfex\r\n" + 
			"2Fd20qpUjkVBbsBNd0o2KkyyjgVAVEcVj6e7+euwcZ/q01g4yMGaXVGVpK55of/K\r\n" + 
			"8Qgih0pa1wYmoWxQcx19WJDm5/0vJBSl2H7KEF5i0ykpsdia87h1NAhMqGvS/+k7\r\n" + 
			"cnp3xnPWTha9HdKxxt0rR5W/J/CdK0HOW8vFDymuJTyQ4Nd3/M3FEYNjXgwP8FD/\r\n" + 
			"VJUZnw0CgYEA3XoPM7OV/Tz/UNlvbuYcMUzcrdHb6bYH8ELf549V10dd6D9lOwwJ\r\n" + 
			"l7aPvkavlfYEgBbaIm6BUdlOMVHhql47N723NK2mavBZvziqwlb/B6oPfmTZ4ML3\r\n" + 
			"CTvLirMUZYj+r5xP1ZnZaFPFiTqbd1UeorN29+1sT/6EQ/R4qN6GPKsCgYEAwY7G\r\n" + 
			"uUiViQbZPefxQmsrzgCQ9xkkoqbp5PcJAQky0g5NfPCPCR5D96Wcf53LwmbbO5c7\r\n" + 
			"Rwj65dK7CQ8q9+bnavu4JgDvkZK6QLjmihI2ZTppdzWe67BzGDU6YPx8boaEE7Q+\r\n" + 
			"qlRSSr1NfqIcntim2O3qm+HUXPDFsTf6FcPiBHcCgYEAz4bM8dQoChd64WYsvUyP\r\n" + 
			"RD7SVWlcWB0CSUZQiajMdaFgw/uLPo3j+y3MeS3A35Kb2u4Ozc6gDHLDiwE/pCUR\r\n" + 
			"9gQlxA2m73NxlPVjRCDCbYsTY4ragXoOgq9t5PQye4WnqCOexvaXOeOtKA4rmODA\r\n" + 
			"iRICuwPUxwwlIYvU998zB2sCgYEAmxSnOjrivMhE9OnKjrnJfiNMAv8dMEjl6/LW\r\n" + 
			"PwM8ubqF8U3YfKjIMjp52nH2mMrKasNv1ilmxQ8Dlm2VssxJrJkEYUasrAlQu5yp\r\n" + 
			"8gRHmvGjIMVQkGxuuv2iyaRimjeiyRrIfrZSvNlRpt2Cau8RN4vgRoc5HEI5UxWT\r\n" + 
			"hS7N/18CgYBGeguiq4ccAozGQZIwlcgdr+RHjPmyIvalxNQTgCRwAsY0Xpah0r6l\r\n" + 
			"hd3HjGG+igf9sGm8Ncp42qQpOy6Be+DAKajYktAKfeeEGM/STZxn6OR7n2BVsbXk\r\n" + 
			"/F5uT1tpA+QHCFNsJe+G87lme7xIHH4xDiqA1R/cr4FCu77RmtM2AA==\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLIC="-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp3SLFxzUXT3gHYLL/f9Q\r\n" + 
			"a+2HYOjMsIY6AWz4oWTR4WZy1JHwtMGSq4kjb1r7Gqo4qYBdKHrAm/aS20pGPCOW\r\n" + 
			"ESB6DrJRVo5w6Wyi6MoYSmXGikJCYchW6MSjjkgxuOMOQfwdy5K3IuoltT3qERvH\r\n" + 
			"gEAcSs/VfPgeh8JuiU+9FuFwD2z25kxkLK1Ax6IEVK41ypJjhJMTDtoPqJ9HrD7u\r\n" + 
			"fctsDSmbqAJAvN6sEoeuH0XXdzpVe+k35nxY4hq2fF48SpW/759Kq8pNWbs9fnJB\r\n" + 
			"/+1Hoh3xl+6ZqBz+XEwYiOBgorz1RmuZWamVl7VYTWJKcwZXDIhXA9ArGmS4WU7f\r\n" + 
			"fQIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";

}
