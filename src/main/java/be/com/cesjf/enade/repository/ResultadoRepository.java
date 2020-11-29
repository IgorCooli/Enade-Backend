package be.com.cesjf.enade.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import be.com.cesjf.enade.dto.ResultadoDTO;
import be.com.cesjf.enade.dto.UsuarioResultadoDTO;
import be.com.cesjf.enade.model.Resultado;

@Repository
@Transactional
public interface ResultadoRepository extends JpaRepository<Resultado, Long>{
	
	@Query("select new be.com.cesjf.enade.dto.ResultadoDTO"
			+ "(r.valorObtido, r.usuario.id, r.prova.id) "
			+ "from Resultado r "
			+ "where r.usuario.id = :usuarioId "
			+ "and r.prova.id = :provaId"
		)
    public ResultadoDTO confereResultado(@Param("usuarioId") Long usuarioId, @Param("provaId") Long provaId);
	

	@Query("select new be.com.cesjf.enade.dto.UsuarioResultadoDTO"
			+ "(r.id, r.usuario.nome, r.usuario.email, r.usuario.senha, r.usuario.tipo.nome, r.valorObtido) "
			+ "from Resultado r "
			+ "inner join Usuario u on r.usuario.id = u.id "
			+ "where r.prova.id = :provaId "
			+ "order by r.id desc"
		)
    public List<UsuarioResultadoDTO> findUltimosDezAlunos(@Param("provaId") Long provaId);
	
	

}
