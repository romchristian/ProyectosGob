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
import py.com.palermo.proyectosgob.dao.ComisionFacade;
import py.com.palermo.proyectosgob.persistencia.Comision;

@Named("comisionController")
@ViewScoped
public class ComisionController implements Serializable {

    @EJB
    private ComisionFacade ejbFacade;
    private List<Comision> items = null;
    private Comision selected;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ComisionController() {
    }

    public Comision getSelected() {
        return selected;
    }

    public void setSelected(Comision selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ComisionFacade getFacade() {
        return ejbFacade;
    }

    public Comision prepareCreate() {
        selected = new Comision();
        initializeEmbeddableKey();
        return selected;
    }

    public List<Comision> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public Comision getComision(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Comision> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Comision> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Comision.class)
    public static class ComisionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ComisionController controller = (ComisionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "comisionController");
            return controller.getComision(getKey(value));
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
            if (object instanceof Comision) {
                Comision o = (Comision) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Comision.class.getName()});
                return null;
            }
        }

    }

}
