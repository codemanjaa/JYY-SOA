package clientWS_LS;

import com.cdyne.ws.IP2Geo;
import com.cdyne.ws.IP2GeoSoap;
import com.cdyne.ws.IPInformation;

public class IpConvertor {
	
	public IpConvertor() {
		
	}
	
	public String getCountry(String ip) {
		IP2Geo IpService = new IP2Geo();
		IP2GeoSoap IpServiceSoap = IpService.getIP2GeoSoap();
		String ipAddress = ip;
		String licenseKey = "0";
		IPInformation ipinfo = IpServiceSoap.resolveIP(ipAddress, licenseKey);
		String country = ipinfo.getCountry() + " " + ipinfo.getCity() + " "+ipinfo.getOrganization();
		return country;
	}
	
	public String getCountryCode(String ip) {
		
		IP2Geo IpService = new IP2Geo();
		IP2GeoSoap IpServiceSoap = IpService.getIP2GeoSoap();
		String ipAddress = ip;
		String licenseKey = "0";
		IPInformation ipinfo = IpServiceSoap.resolveIP(ipAddress, licenseKey);
		String countryCode = ipinfo.getCountryCode();
		return countryCode;
	}

}
