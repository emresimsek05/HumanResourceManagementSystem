package kodlamaio.HumanResourceManagementSystem.business.concretes;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.SchoolDepartmentService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.SchoolDepartmentDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolDepartmentManager implements SchoolDepartmentService {
    private SchoolDepartmentDao schoolDepartmentDao;

    @Autowired
    public SchoolDepartmentManager(SchoolDepartmentDao schoolDepartmentDao){
        this.schoolDepartmentDao = schoolDepartmentDao;
    }

    @Override
    public DataResult<List<SchoolDepartment>> getAll() {
        return new SuccessDataResult<List<SchoolDepartment>>(schoolDepartmentDao.findAll());
    }

    @Override
    public Result add(SchoolDepartment schoolDepartment) {
        schoolDepartmentDao.save(schoolDepartment);
        return new SuccessResult("başarıyla eklendi");

    }
}
