package jobseekingbe.api.service.AuthService;

import java.util.Map;

import jakarta.servlet.http.HttpServletResponse;
public interface AuthService {
    public String login(Map<String,String> info,HttpServletResponse response);
    public String logout(HttpServletResponse response);
}
