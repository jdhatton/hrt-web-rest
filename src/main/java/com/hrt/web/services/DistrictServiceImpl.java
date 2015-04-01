/**
 * 
 */
package com.hrt.web.services;

import java.util.List;

import com.hrt.data.db.beans.District;

/**
 * @author jdhatton
 *
 */
public class DistrictServiceImpl implements DistrictService {

	/**
	 * 
	 */
	public DistrictServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.hrt.web.services.DistrictService#addDistrict(com.hrt.data.db.beans.District)
	 */
	public void addDistrict(District district) {
		
		  User user = new User();
	        user.setCreatedDate(new DateTime());
	        // i can't see a scenario where we will get duplicates here since the key is autoincrement
	        user.setUserId(Db.dao(UserDao.class).insert(user));

	        externalUser.setUserId(user.getUserId());
	        try {
	            // insert the user and handle a constraint violation exception
	            UpdateExternalUser updateUser = translateForUpdateExternalUser(externalUser);
	            Db.dao(UpdateExternalUserDao.class).insert(updateUser);
	        } catch (UnableToExecuteStatementException e) {
	            // if the exception is a constraint violation exception then go ahead and pass that up so the caller can handle it.
	            if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
	                throw new DuplicateExternalUserException();
	            }
	            throw e;
	        }

	}

	/* (non-Javadoc)
	 * @see com.hrt.web.services.DistrictService#findById(long)
	 */
	public District findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hrt.web.services.DistrictService#findAll()
	 */
	public List<District> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
