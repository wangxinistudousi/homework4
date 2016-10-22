package bjtu.headerParser;

import java.util.HashMap;

import bjtu.header.RequestHeader;

public class RequestHeaderParser implements IRequestHeaderParser{
	/** 
     * ����HTTP����ͷ 
     */  
    public RequestHeader parse(String txt) throws Exception {  
        RequestHeader header = new RequestHeader();  
        header.setTxt(txt);  
        // ��ȡ����ͷ��һ��  
        String firstLine = txt.substring(0, txt.indexOf("\n"));  
        String method = firstLine.substring(0, firstLine.indexOf(" "));  
        String url = firstLine.substring(firstLine.indexOf(" ") + 1, firstLine.lastIndexOf(" "));  
        String protocal = firstLine.substring(firstLine.lastIndexOf(" ") + 1, firstLine.length());  
          
        header.setMethod(method);// ��ȡAccept����ֵ����ŵ�RequestHeader������  
        header.setUrl(url);// ��ȡAccept����ֵ����ŵ�RequestHeader������  
        header.setProtocal(protocal);// ��ȡAccept����ֵ����ŵ�RequestHeader������  
          
        String[] lines = txt.split("\n");  
        HashMap<String, String> map = new HashMap<String, String>();  
        // ������ͷ�ڶ��п�ʼ�ָ�����Ϊ��һ��û��ð��  
        for (int i = 1; i < lines.length; i++) {  
            String[] result = lines[i].split(": ");  
            map.put(result[0], (result.length <= 1) ? "" : result[1].replace('\n', ' ').trim());  
        }  
        String parameter = null;  
        try {  
            if(method.equalsIgnoreCase("post")) {  
                parameter = txt.substring(txt.lastIndexOf("\n") + 1, txt.length());  
            } else if(method.equalsIgnoreCase("get")) {  
                parameter = url.substring(url.indexOf("?") + 1, url.length());  
                url = url.substring(0, url.indexOf("?"));  
            }  
        } catch (Exception e) {  
        }  
        
        header.setParameter(parameter);
        header.setMap(map); 
        header.setAccept(map.get("Accept")); // ��ȡAccept����ֵ����ŵ�RequestHeader������  
        header.setAccept_language(map.get("Accept-Language")); // ��ȡAccept-Language����ֵ����ŵ�RequestHeader������  
        header.setUser_agent(map.get("User-Agent")); // ��ȡUser-Agent����ֵ����ŵ�RequestHeader������  
        header.setAccept_encoding(map.get("Accept-Encoding")); // ��ȡAccept-Encoding����ֵ����ŵ�RequestHeader������  
        header.setIp(map.get("Host").split(":")[0]); // ��ȡHost������IP����ֵ����ŵ�RequestHeader������  
        header.setPort(map.get("Host").split(":")[1]); // ��ȡHost������Port����ֵ����ŵ�RequestHeader������  
        header.setConnection(map.get("Connection")); // ��ȡConnection����ֵ����ŵ�RequestHeader������
        header.setCookie(map.get("Cookie")); // ��ȡCookie����ֵ����ŵ�RequestHeader������
        
        return header;  
    }  
}

