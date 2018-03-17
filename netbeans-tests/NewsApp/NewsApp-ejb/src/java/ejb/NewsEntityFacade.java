package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author steven.mendez
 * @since Dec 21 2017
 * @version 1.0
 */
@Stateless
public class NewsEntityFacade extends AbstractFacade<NewsEntity> {

    @PersistenceContext(unitName = "NewsApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NewsEntityFacade() {
        super(NewsEntity.class);
    }

}
