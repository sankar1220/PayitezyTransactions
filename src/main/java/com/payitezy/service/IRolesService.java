package com.payitezy.service;

import com.payitezy.domain.Roles;

import java.util.List;

public interface IRolesService {

    Roles create(Roles roles);

    void deleteRoles(String rolesId);

    List<Roles> getAll();

    Roles getRoles(String rolesId);

    Roles updateRoles(Roles roles);

}
