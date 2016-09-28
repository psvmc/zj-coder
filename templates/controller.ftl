package ${namespace};

import zj.jfinalExt.ZJ_Db;
import zj.model.*;
import zj.utils.*;
import zj.vo.PageVo;
import zj.vo.ViewDataVo;
import zj.vo.ui.EasyuiDatagrid;

import com.jfinal.core.Controller;
import com.jfinal.log.Logger;
import com.jfinal.render.JsonRender;

public class ${tablePojo.className}${fileNameSuffix} extends Controller
{
    @SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(Object.class);

    public void index()
    {
        render("/ht/${tablePojo.objectsName}/${tablePojo.objectsName}_list.html");
    }
    

    public void datagrid()
    {
        PageVo pageModel = new PageVo();
        ZJ_BeanUtils.copyPropertiesMapArray(getParaMap(), pageModel, false);
        EasyuiDatagrid datagrid = new EasyuiDatagrid();
        datagrid = ${tablePojo.className}.dao.datagrid(pageModel);
        render(new JsonRender(datagrid).forIE());
    }

    public void add()
    {
        render("/ht/${tablePojo.objectsName}/${tablePojo.objectsName}_add.html");
    }

    public void save()
    {
        ViewDataVo vd = new ViewDataVo();
        vd.setSuccess(getModel(${tablePojo.className}.class).set("id", ZJ_GeneratorUtils.idGenerator()).save());
        vd.setMsg("添加成功");
        render(new JsonRender(vd).forIE());
    }

    public void delete()
    {
        ViewDataVo vd = new ViewDataVo();
        String ids = getPara("ids");
        boolean b = ZJ_Db.dels(${tablePojo.className}.class, ids);
        vd.setSuccess(b);
        vd.setObj(ids);
        if (b)
        {
            vd.setMsg("删除成功");
        }
        else
        {
            vd.setMsg("删除失败");
        }
        render(new JsonRender(vd).forIE());
    }

    public void edit()
    {
        ${tablePojo.className} ${tablePojo.objectsName} = ${tablePojo.className}.dao.findById(getPara("id"));
        setAttr("${tablePojo.objectsName}", ${tablePojo.objectsName});
        render("/ht/${tablePojo.objectsName}/${tablePojo.objectsName}_edit.html");
    }

    public void update()
    {
        ViewDataVo vd = new ViewDataVo();
        boolean b=getModel(${tablePojo.className}.class).update()
        vd.setSuccess(b);
        if(b){
        vd.setMsg("修改成功");
        }else{
        vd.setMsg("修改失败");
        }

        render(new JsonRender(vd).forIE());
    }
}
