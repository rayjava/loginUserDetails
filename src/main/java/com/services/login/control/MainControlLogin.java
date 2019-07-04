package com.services.login.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.services.login.modelo.Usuarios;
import com.services.login.servicio.usuarioDao;

@Controller
@RequestMapping(value="/")
public class MainControlLogin {
@Autowired
usuarioDao usuariodao;
	/*@RequestMapping(value="")
	public String inicio() {
	// 	mp.put("","");
		return "login";			
	}
	*/
//  ESte es el @RequestMapping que va a llamr desde la configuracion HttpSecurity
	@RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
	public ModelAndView login() { 
		ModelAndView model = new ModelAndView();
	  model.setViewName("login");
	  return model; }
	//
	@RequestMapping(value= {"/registro"}, method=RequestMethod.GET)
	public ModelAndView registro() { 
		ModelAndView model = new ModelAndView();
	  model.setViewName("registro");
	  return model; }
	//
	@RequestMapping("/_login")
	public ModelAndView logusu(@Valid Usuarios user, BindingResult bindingResult) throws Exception {
		
		try{
	    ModelAndView modelo = new ModelAndView();
		
        Usuarios usuarioexist = usuariodao.findOne(user.getUsername());
        if (usuarioexist == null) 
           { return modelo.addObject("mess","Usuario y/o Password NO existen" );}
           else
        	{return modelo.addObject("mess","Usuario y Password Correctos" );}
         
        
	}catch (Exception e){
		throw e;
	 }
	}
	 @RequestMapping("/__login.do")
	    public @ResponseBody String login__(@RequestParam("login") String login_usuario) throws Exception {
	    	
	    	try{
	    	 Usuarios usuario = usuariodao.findOne(login_usuario);
	    //	 Usuarios clave = usuariodao.findOne(login_clave);
	         if (usuario == null)
	         { return "Usuario o Password <strong>no</strong> existen";}
	         else
	        	{return "Usuario y Password Correctos";}
	        	
	        
	    	}catch (Exception e){
	    		throw e;
	    	}
	      }
	    @RequestMapping("/login_.do")
	    public @ResponseBody String login_(@RequestParam("login") String login_usuario)   {
	    	
	    	 
	    	 Usuarios usuario = usuariodao.findOne(login_usuario);
	        if (usuario == null)
	        { return "Usuario  <strong>no</strong> existe";}
	        else
	        	{return "Usuario Correcto";}
	        
	    	 
	      }
}
