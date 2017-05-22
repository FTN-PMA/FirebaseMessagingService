package rs.ftn.reviewer.rest.dao;

/**
 * Sluzi za oznacavanje entiteta za perzistenciju.
 * @author biohazard1491
 *
 */
public interface IEntity {
		
	public Object[] getValues();
	
	public Integer getId();

}
