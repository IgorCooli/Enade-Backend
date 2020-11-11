package be.com.cesjf.enade.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.com.cesjf.enade.model.TipoUsuario;

@Repository
@Transactional
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long>{

}
