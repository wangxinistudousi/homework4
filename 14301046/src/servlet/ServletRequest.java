package servlet;

import java.util.ArrayList;
import java.util.List;

import bjtu.header.RequestHeader;

public class ServletRequest {
	// ��������ͷ  
    private RequestHeader header;  
    //����
	private String characterEncoding;
	
	public String getCharacterEncoding() {
		return characterEncoding;
	}
	
	public void setCharacterEncoding(String characterEncoding) {
		this.characterEncoding = characterEncoding;
	}
	
    // ���ò�������  
    
    // �����������  
    public void setParameter(String param) {  
        /*if(param == null || param.trim().equals("")) {  
            return;  
        }  
          
        String[] result = param.split("&");  
          
        for (int i = 0; i < result.length; i++) {  
        	RequestParameter parameter = new RequestParameter();  
            parameter.setKey(result[i].split("=")[0]);  
            parameter.setValue((result[i].split("=").length <= 1) ? "" : result[i].split("=")[1]);  
            params.add(parameter);  
        }  */
    }  
    // ��ȡ���������ֵ  
    public String getParameter(String key) {  
    	/*
        String result = null;  
        for(RequestParameter parameter : params) {  
            if(parameter.getKey().equals(key)) {  
                result =  parameter.getValue();  
            }  
        } */ 
        return null;  
        
    }  
  
    public RequestHeader getHeader() {  
        return header;  
    }  
  
    public void setHeader(RequestHeader header) {  
        this.header = header;  
    }  
}
