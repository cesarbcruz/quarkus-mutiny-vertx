package br.exemplo.livro;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.exemplo.livro.model.Livro;
import br.exemplo.livro.model.PartesLivroConst;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.EventBus;
import io.vertx.mutiny.core.eventbus.Message;

@Path("livro")
public class LivroResource {
     
    @Inject 
    EventBus eventBus;

    @GET
    @Path("/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Livro> obterLivro(Integer isbn) {
                
        Uni<String> uniCapa = eventBus.<String>request(PartesLivroConst.CAPA, isbn)
                  .onItem().transform(Message::body);
        Uni<String> uniFolhaRosto = eventBus.<String>request(PartesLivroConst.FOLHADEROSTO, isbn)
                  .onItem().transform(Message::body);
        Uni<String> uniCorpo = eventBus.<String>request(PartesLivroConst.CORPO, isbn)
                  .onItem().transform(Message::body);
        Uni<String> uniConclusao = eventBus.<String>request(PartesLivroConst.CONCLUSAO, isbn)
                  .onItem().transform(Message::body);
        Uni<String> uniReferencia = eventBus.<String>request(PartesLivroConst.REFERENCIAS, isbn)
                  .onItem().transform(Message::body);
        
        return Uni.combine().all().unis(uniCapa, uniFolhaRosto, uniCorpo, uniConclusao, uniReferencia)
                  .combinedWith(result -> {
                       Livro livro = new Livro();
                       livro.setCapa(result.get(0).toString());
                       livro.setFolhaDeRosto(result.get(1).toString());
                       livro.setCorpo(result.get(2).toString());
                       livro.setConclusao(result.get(3).toString());
                       livro.setReferencias(result.get(4).toString());
                       return livro;
                   });
    }
}