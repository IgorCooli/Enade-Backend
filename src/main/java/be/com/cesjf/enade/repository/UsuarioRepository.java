package be.com.cesjf.enade.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import be.com.cesjf.enade.dto.UsuarioDTO;
import be.com.cesjf.enade.dto.UsuarioResultadoDTO;
import be.com.cesjf.enade.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	

	@Query("select new be.com.cesjf.enade.dto.UsuarioDTO"
			+ "(u.id, u.nome, u.email, u.senha, u.tipo.nome) "
			+ "from Usuario u "
			+ "where u.id = :id"
		)
    public UsuarioDTO findUsuarioById(@Param("id") Long id);
	
	
	
	@Query("select new be.com.cesjf.enade.dto.UsuarioDTO"
			+ "(u.id, u.nome, u.email, u.senha, u.tipo.nome) "
			+ "from Usuario u "
		)
    public List<UsuarioDTO> findAllUsuario();
	
	@Query("select new be.com.cesjf.enade.dto.UsuarioDTO"
			+ "(u.id, u.nome, u.email, u.senha, u.tipo.nome) "
			+ "from Usuario u "
			+ "where u.tipo = 1"
		)
    public List<UsuarioDTO> findAllAlunos();
	
	@Query("select new be.com.cesjf.enade.dto.UsuarioDTO"
			+ "(u.id, u.nome, u.email, u.senha, u.tipo.nome) "
			+ "from Usuario u "
			+ "where u.email = :email "
			+ "and u.senha = :senha"
		)
    public UsuarioDTO login(@Param("email") String email, @Param("senha") String senha);
	
	@Query("select new be.com.cesjf.enade.dto.UsuarioResultadoDTO"
			+ "(u.id, u.nome, u.email, u.senha, u.tipo.nome, r.valorObtido) "
			+ "from Usuario u "
			+ "inner join Resultado r on u.id = r.usuario.id "
			+ "where r.prova.id = :id "
		)
    public List<UsuarioResultadoDTO> findAllAlunosFizeramProva(@Param("id") Long id);


}
