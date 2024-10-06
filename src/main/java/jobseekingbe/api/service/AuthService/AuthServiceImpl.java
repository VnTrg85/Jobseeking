package jobseekingbe.api.service.AuthService;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jobseekingbe.api.entity.User;
import jobseekingbe.api.repository.UserRepository;
import jobseekingbe.api.service.Security.SecurityService;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired 
    private UserRepository userRepository;
    @Autowired
    private SecurityService securityService;
    @Override
    public String login(Map<String, String> params,HttpServletResponse response) {
        List<User> users = userRepository.findAll();
        if(users != null) {
            for (User user : users) {
                if(user.getEmail().equals(params.get("email"))) {
                    String decodePass = securityService.decode(user.getPassword());

                    if(decodePass.equals(params.get("password"))) {
                        // Generate a JWT token
                        String jwtToken = securityService.generateToken(user.getEmail());
                        // Create a cookie with the JWT token
                        Cookie cookie = new Cookie("auth_token", jwtToken);
                        cookie.setHttpOnly(true);  // Prevent access from JavaScript
                        cookie.setMaxAge(86400);   // 1 day expiry
                        cookie.setPath("/");       // Accessible for the whole application
                        cookie.setSecure(false);
                        response.addCookie(cookie);

                        return  user.getId().toString() + ","+ cookie.getValue();
                    }
                    else {
                        return "Password is incorrect";
                    }
                }
            }
            return "Email not valid";
        }
        return "This account is not found";
    }

    @Override
    public String logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("auth_token", null);
        cookie.setMaxAge(0);  
        cookie.setPath("/");
        // Add the cookie to the response
        response.addCookie(cookie);
        return "Logout successful";
    }

}
