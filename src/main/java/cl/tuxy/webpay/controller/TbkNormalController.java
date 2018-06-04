package cl.tuxy.webpay.controller;

import cl.transbank.webpay.Webpay;
import cl.transbank.webpay.WebpayNormal;
import cl.tuxy.webpay.dto.TrxNormal;
import com.transbank.webpay.wswebpay.service.TransactionResultOutput;
import com.transbank.webpay.wswebpay.service.WsInitTransactionOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

/**
 * Created by josebovet on 11/21/16.
 */
@Controller
public class TbkNormalController {

    @Autowired
    Webpay webpay;

    @Value("${transbank.webpay.url.return}")
    private String urlReturn;

    @Value("${transbank.webpay.url.final}")
    private String urlFinal;

    @RequestMapping(value = "/")
    public String index(Model model) throws Exception {
        WebpayNormal normalTransaction = webpay.getNormalTransaction();
        Random r = new Random();
        int menor = 150987676;
        int mayor = 356000000;
        int intervalo = mayor - menor;
        int random = r.nextInt(intervalo) + menor;
        int monto = 1000;
        String idSession = "aj2h4kj2"; //random?
        String buyOrder = String.valueOf(random);
        WsInitTransactionOutput wsInit = normalTransaction.initTransaction(monto, idSession, buyOrder, urlReturn, urlFinal);

        TrxNormal trxNormal = new TrxNormal();
        trxNormal.setMonto(monto);
        trxNormal.setIdSesion(idSession);
        trxNormal.setOrden(Integer.parseInt(buyOrder));
        trxNormal.setToken(wsInit.getToken());
        trxNormal.setUrl(wsInit.getUrl());

        model.addAttribute("trxNormal", trxNormal);
        return "tbknormal";

    }

    @RequestMapping(value = "/confirmaPago", method = RequestMethod.POST)
    public String confirmaPago(@RequestParam(value = "token_ws") String token_ws, Model model) throws Exception {
        TransactionResultOutput result;
        result = webpay.getNormalTransaction().getTransactionResult(token_ws);
        model.addAttribute("token_ws", token_ws);
        model.addAttribute("urlVoucer", result.getUrlRedirection());
        model.addAttribute("VCI", result.getVCI());
        boolean error = false;

        if (!result.getDetailOutput().isEmpty()) {
            //TODO almacenar datos de respuesta
            model.addAttribute("authorizationCode", result.getDetailOutput().get(0).getAuthorizationCode());
            model.addAttribute("authorizedAmount", result.getDetailOutput().get(0).getAmount().toString());
            model.addAttribute("buyOrder", result.getDetailOutput().get(0).getBuyOrder());
            Integer responseCode = result.getDetailOutput().get(0).getResponseCode();
            model.addAttribute("responseCode", responseCode);
            error = (!responseCode.equals(0));
        }

        if (error) {
            return "errorWebpay";
        }

        return "voucher";
    }

    @RequestMapping(value = "/finTrx", method = RequestMethod.POST)
    public String finalizaTrx(@RequestParam(value = "token_ws", required = false) String token_ws,
                              @RequestParam(value = "TBK_TOKEN", required = false) String tbkToken) {
        //TODO guardar token para posterior anulacion...

        //TBK_TOKEN anulacion en pago - wtf?
        //why TRANSBANK!!! why!!!
        System.out.println(tbkToken);
        System.out.println(token_ws);

        return "finPago";
    }

}
