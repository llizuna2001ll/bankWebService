import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;

public class ClientWS {
    public static void main(String[] args) {

        BanqueService stubWS = new BanqueWS().getBanqueServicePort();
        System.out.println(stubWS.conversionEuroToMad(500));

        Compte cp = stubWS.getCompte(2L);

        System.out.println(cp.getCode());
        System.out.println(cp.getSolde());
        List<Compte> comptes = stubWS.listComptes();

        comptes.forEach (c->{
            System.out.println("----------------------");
            System.out.println(c.getCode());
            System.out.println(c.getSolde());
        });

    }
}
