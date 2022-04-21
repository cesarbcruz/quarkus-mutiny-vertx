package br.exemplo.livro.service;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.logging.Logger;

import br.exemplo.livro.model.PartesLivroConst;
import io.quarkus.vertx.ConsumeEvent;

@ApplicationScoped
public class LivroService {
     
     private static final Logger LOG = Logger.getLogger(LivroService.class);

     @ConsumeEvent(value=PartesLivroConst.CAPA)
     public String criarCapa(Integer isbn) throws InterruptedException {
         String capa = "Capa do livro ISBN: "+isbn;
         LOG.info(capa);
         return capa;
     }
     
     @ConsumeEvent(value=PartesLivroConst.FOLHADEROSTO)
     public String criarFolhaDeRosto(Integer isbn) {
         String folhaRosto = "Folha de Rosto ISBN: "+isbn;
         LOG.info(folhaRosto);
         return folhaRosto;
     }
     
     @ConsumeEvent(value=PartesLivroConst.CORPO)
     public String criarCorpo(Integer isbn) throws InterruptedException {
         Thread.sleep(1000); // simulação
         String corpo = "Corpo / Desenvolvimento ISBN: "+isbn;
         LOG.info(corpo);
         return corpo;
     }
     
     @ConsumeEvent(value=PartesLivroConst.CONCLUSAO)
     public String criarConclusao(Integer isbn) {
         String conclusao = "Conclusão ISBN: "+isbn;
         LOG.info(conclusao);
         return conclusao;
     }
     
     @ConsumeEvent(value=PartesLivroConst.REFERENCIAS)
     public String criarReferencias(Integer isbn) {
         String referencias = "Referências ISBN: "+isbn;
         LOG.info(referencias);
         return referencias;         
     }

}
