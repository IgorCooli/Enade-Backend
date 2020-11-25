package be.com.cesjf.enade.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import be.com.cesjf.enade.dto.QuestaoDTO;
import be.com.cesjf.enade.model.Questao;

@Repository
@Transactional
public interface QuestaoRepository extends JpaRepository<Questao, Long>{
	
	@Query("select new be.com.cesjf.enade.dto.QuestaoDTO"
			+ "(q.id, q.descricao, q.alternativaA, q.alternativaB, q.alternativaC, "
			+ "q.alternativaD, q.alternativaE, q.questaoCorreta, q.tipoQuestao.id, q.estado) "
			+ "from Questao q "
		)
    public List<QuestaoDTO> findAllQuestao();
	
	@Query("select new be.com.cesjf.enade.dto.QuestaoDTO"
			+ "(q.id, q.descricao, q.alternativaA, q.alternativaB, q.alternativaC, "
			+ "q.alternativaD, q.alternativaE, q.questaoCorreta, q.tipoQuestao.id, q.estado) "
			+ "from Questao q "
			+ "where q.estado = 1"
		)
    public List<QuestaoDTO> findAllQuestaoAtiva();

}
