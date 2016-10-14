/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escambovirtual.controller;

import escambovirtual.model.entity.Anunciante;
import escambovirtual.model.entity.Item;
import escambovirtual.model.entity.Mensagem;
import escambovirtual.model.service.ItemService;
import escambovirtual.model.service.MensagemService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Joao
 */
@Controller
public class MensagemController {

    @RequestMapping(value = "/anunciante/mensagem/item/{idItem}", method = RequestMethod.GET)
    public ModelAndView getMensagenAnunciante(@PathVariable Long idItem, HttpSession session) {
        ModelAndView mv;
        try {
            Anunciante anunciante = (Anunciante) session.getAttribute("usuarioSessao");
            if (idItem != null) {
                ItemService s = new ItemService();
                Item item = s.readById(idItem);

                if (item != null) {
                    mv = new ModelAndView("mensagem/enviar-msg");
                    mv.addObject("anunciante", anunciante);
                    mv.addObject("item", item);
                } else {
                    mv = new ModelAndView("usuario/anunciante/item/item-not-found");
                    mv.addObject("anunciante", anunciante);
                }
            } else {
                mv = new ModelAndView("usuario/anunciante/item/item-not-found");
                mv.addObject("anunciante", anunciante);
            }
        } catch (Exception e) {
            mv = new ModelAndView("error");
            mv.addObject("error", e);
        }
        return mv;
    }

    @RequestMapping(value = "/anunciante/mensagem/item/{idItem}", method = RequestMethod.POST)
    public ModelAndView postMensagenAnunciante(@PathVariable Long idItem, HttpSession session, String texto) {
        ModelAndView mv;

        try {
            Mensagem mensagem = new Mensagem();
            ItemService s = new ItemService();
            Item item = s.readById(idItem);
            mensagem.setItem(item);
            mensagem.setDestinatario(item.getAnunciante());
            mensagem.setTexto(texto);
            Anunciante remetente = (Anunciante) session.getAttribute("usuarioSessao");
            mensagem.setRemetente(remetente);

            Date date = new Date();
            mensagem.setData_hora_envio(date);

            MensagemService msgS = new MensagemService();

            msgS.create(mensagem);

            mv = new ModelAndView("redirect:/anunciante/mensagem/list");
        } catch (Exception e) {
            mv = new ModelAndView("error");
            mv.addObject("error", e);
        }
        return mv;
    }
    
    @RequestMapping(value = "/anunciante/mensagem/list", method = RequestMethod.GET)
    public ModelAndView getMensagemList(HttpSession session){
        ModelAndView mv;
        
        try{
            Anunciante anunciante = (Anunciante) session.getAttribute("usuarioSessao");
            mv = new ModelAndView("mensagem/list");
            mv.addObject("anunciante", anunciante);
        }catch(Exception e){
            mv = new ModelAndView("error");
            mv.addObject("error", e);
        }
        return mv;
    }
}
