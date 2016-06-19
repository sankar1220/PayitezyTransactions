package com.payitezy.service;

import com.payitezy.dao.RolesRepository;
import com.payitezy.domain.Roles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolesService implements IRolesService {
    @Autowired
    private RolesRepository rolesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IRolesService#create(com.meat.domain.Roles)
     */
    @Override
    public Roles create(final Roles roles) {
        // TODO Auto-generated method stub
        return rolesRepository.save(roles);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IRolesService#deleteRoles(java.lang.String)
     */
    @Override
    public void deleteRoles(final String rolesId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IRolesService#getAll()
     */
    @Override
    public List<Roles> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IRolesService#getRoles(java.lang.String)
     */
    @Override
    public Roles getRoles(final String rolesId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IRolesService#updateRoles(com.meat.domain.Roles)
     */
    @Override
    public Roles updateRoles(final Roles roles) {
        // TODO Auto-generated method stub
        return null;
    }

}
