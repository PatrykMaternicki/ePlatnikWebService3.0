package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;

public class FactoryDAOImpl implements iFactoryDAO {

    Repository productDAO;
    @Override
    public Repository getProduct() {
        return productDAO;
    }

    @Override
    public void buildProduct(DAOProperties.Type typeDAO) {
        switch(typeDAO){
            case AddressDAO: {productDAO = new AddressDAO(); break;}
            case BeforeEmployersDAO: {productDAO = new BeforeEmployersDAO(); break;}
            case BonusDAO: {productDAO = new BonusDAO(); break;}
            case ContractDAO: {productDAO = new ContractDAO(); break;}
            case CourseDAO : { productDAO = new CourseDAO(); break;}
            case EducationDAO: {productDAO = new EducationDAO(); break;}
            case PersonDAO: {productDAO = new PersonDAO(); break;}
            case PersonInformationDAO: {productDAO = new PersonInformationDAO(); break;}
            case RaportOfWorkDAO: {productDAO  = new RaportOfWorkDAO(); break;}
            default: {throw new EnumConstantNotPresentException(DAOProperties.Type.class, "Not found typeDAO");}
        }
    }
}
