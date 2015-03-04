package py.com.palermo.proyectosgob.web;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import py.com.palermo.proyectosgob.dao.RolesFacade;
import py.com.palermo.proyectosgob.persistencia.Roles;

@Named("rolController")
@ViewScoped
public class RolController implements Serializable {

    @EJB
    private RolesFacade ejbFacade;
    private List<Roles> items = null;
    private Roles selected;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void cargaDatos() {
        selected = getRol(id);
    }

    public RolController() {
    }

    public Roles getSelected() {
        return selected;
    }

    public void setSelected(Roles selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RolesFacade getFacade() {
        return ejbFacade;
    }

    public List<Roles> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public Roles getRol(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Roles> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Roles> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Roles.class, value = "rolConverter")
    public static class RolControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RolController controller = (RolController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "rolController");
            return controller.getRol(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Roles) {
                Roles o = (Roles) object;
                return getStringKey(o.getRoleid());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Roles.class.getName()});
                return null;
            }
        }

    }

}
