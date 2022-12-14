package pe.com.escuelanuevaweb.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import pe.com.escuelanuevaweb.servicio.UsuarioService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioService usuarioservicesecurity;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(usuarioservicesecurity);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(
                "/registro**",
                "/rol**",
                "/js/**",
                "/css/**",
                "/css**",
                "/fonts/**",
                "/images/**",
                "/scss/**",
                "/img/**",
                "/static/**",
                "/productos**",
                "/productos/**",
                "/categoria/**",
                "/categoria**",
                 "/empleado**",
                "/empleado/**",
                "/distrito/**",
                "/distrito**",
                 "/destino**",
                "/destino/**",
                "/proveedores/**",
                "/proveedores**",
                 "/entrada_producto**",
                "/entrada_producto/**",
                "/detalle_entrada/**",
                "/detalle_entrada**",
                 "/salida_producto**",
                "/salida_producto/**",
                "/detalle_salida/**",
                "/detalle_salida**"
        ).permitAll().anyRequest().authenticated().and().formLogin()
                .loginPage("/login").permitAll().and()
                .logout().invalidateHttpSession(true).clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout").permitAll();
        //permitir el metodo post, put y delete
        http.csrf().disable();
    }

}
