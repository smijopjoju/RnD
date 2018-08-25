package my.rnd.practice.trial;
/*package my.rnd.trial;

import java.util.Arrays;
import java.util.UUID;

import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.bhge.prod.link.alarm.config.domain.UserSpecProdAlarmSettings;
import com.bhge.prod.link.alarm.config.rest.UserSpecificProductionActiveAlarmsResponse;
import com.bhge.prod.link.alarm.config.rest.UserSpecificProductionAlarmsRequest;

public class RestPutExample {

	public static void main(String args[]) {
		test();
	}
	
	public static <T, R> R makePutRequest(String url, T requestObj, Class responseClassType) {
		
		try {
				ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
				RestTemplate restTemp = new RestTemplate(requestFactory);
				HttpHeaders httpHeaders = new HttpHeaders();
				SimpleClientHttpRequestFactory httpReqFac =
					    (SimpleClientHttpRequestFactory) restTemp.getRequestFactory();
				HttpEntity<T> requestUpdate = new HttpEntity<T>(requestObj);
				return (R) restTemp.exchange(url, HttpMethod.PUT, requestUpdate, responseClassType);
				
		} catch(Exception e) {
			e.printStackTrace();			
		}
		
		return null;
	}
	
	public static void test() {
		try {
			UserSpecProdAlarmSettings settings = new UserSpecProdAlarmSettings();
			settings.setUserid(UUID.randomUUID().toString());
			UserSpecificProductionAlarmsRequest userSpecProdActiveAlarmRequest = new  UserSpecificProductionAlarmsRequest(Arrays.asList(settings));
			
			ResponseEntity<UserSpecificProductionActiveAlarmsResponse> respEntity =		makePutRequest("http://10.91.57.164:8080/user-specific-alarm/production-alarms/createProductionAlarms",userSpecProdActiveAlarmRequest, UserSpecificProductionActiveAlarmsResponse.class);
			UserSpecificProductionActiveAlarmsResponse responseObj = respEntity.getBody();
		} catch( Exception e) {
			e.printStackTrace();
		}
		
	}
}
*/