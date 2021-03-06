package self.srr.jast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import self.srr.jast.model.entity.TblAstSetting;

/**
 * Setting repository
 */
@Repository
public interface TblAstSettingRepository extends JpaRepository<TblAstSetting, Long>, QueryByExampleExecutor<TblAstSetting> {

    TblAstSetting findOneBySettingGroup(String settingGroup);
}
