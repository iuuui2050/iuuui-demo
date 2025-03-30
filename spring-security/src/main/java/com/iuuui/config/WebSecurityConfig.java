package com.iuuui.config;

import com.iuuui.interpector.AuthenticationEntryPointImpl;
import com.iuuui.interpector.JwtAuthenticationTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author iuuui
 * @date 2025/03/29 1432
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter, AuthenticationEntryPointImpl authenticationEntryPoint) throws Exception {
        return http
                // 禁用Session模式,前后端分离不需要
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 禁用默认的登录表单,前后端分离不需要
                .formLogin().disable()
                // 禁用默认的退出表单,前后端分离不需要
                .logout().disable()
                // 禁用 CSRF 保护,前后端分离不需要
                .csrf().disable()

                // 授权请求操作
                .authorizeHttpRequests()
                // POST请求的登录login接口放行,不需要认证即可访问
                .antMatchers("/login").permitAll()
                /*.antMatchers(HttpMethod.GET, "/sysUser/disable", "/sysUser/enable").hasAuthority("user:status:update")
                .antMatchers("/sysUser/list").hasAuthority("user:select")*/
                // 所有请求需要认证才能访问
                .anyRequest().authenticated().and()
                // 认证失败处理
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
                // 把JWT认证过滤器加入到过滤器链中,放在UsernamePasswordAuthenticationFilter之前
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
