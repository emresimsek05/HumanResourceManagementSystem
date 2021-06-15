package kodlamaio.HumanResourceManagementSystem.business.concretes;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.DepartmentService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.DepartmentDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManager implements DepartmentService {
    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentManager(DepartmentDao departmentDao){
        this.departmentDao = departmentDao;
    }
    @Override
    public DataResult<List<Department>> getAll() {
        return new SuccessDataResult<List<Department>>(departmentDao.findAll());
    }

    @Override
    public Result add(Department department) {
       departmentDao.save(department);
        return new SuccessResult("başarıyla eklendi");
    }
}
