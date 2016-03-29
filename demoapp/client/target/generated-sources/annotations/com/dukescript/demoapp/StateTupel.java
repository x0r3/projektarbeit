package com.dukescript.demoapp;
import net.java.html.json.*;
public final class StateTupel implements Cloneable {
  private static final Html4JavaType TYPE = new Html4JavaType();
  private final org.netbeans.html.json.spi.Proto proto;
  private java.lang.String prop_id;
  public java.lang.String getId() {
    proto.accessProperty("id");
    return prop_id;
  }
  public void setId(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_id;
    if (TYPE.isSame(o , v)) return;
    prop_id = v;
    proto.valueHasMutated("id", o, v);
  }
  private final java.util.List<Transition> prop_transitions;
  public java.util.List<Transition> getTransitions() {
    proto.accessProperty("transitions");
    return prop_transitions;
  }
  private final java.util.List<java.lang.Integer> prop_coords;
  public java.util.List<java.lang.Integer> getCoords() {
    proto.accessProperty("coords");
    return prop_coords;
  }
  private int prop_diameter;
  public int getDiameter() {
    proto.accessProperty("diameter");
    return prop_diameter;
  }
  public void setDiameter(int v) {
    proto.verifyUnlocked();
    Object o = prop_diameter;
    if (TYPE.isSame(o , v)) return;
    prop_diameter = v;
    proto.valueHasMutated("diameter", o, v);
  }
  private java.lang.String prop_color;
  public java.lang.String getColor() {
    proto.accessProperty("color");
    return prop_color;
  }
  public void setColor(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_color;
    if (TYPE.isSame(o , v)) return;
    prop_color = v;
    proto.valueHasMutated("color", o, v);
  }
  private static Class<UIModel.stateTupelModel> modelFor() { return null; }
  private StateTupel(net.java.html.BrwsrCtx context) {
    this.proto = TYPE.createProto(this, context);
    this.prop_transitions = proto.createList("transitions", -1);
    this.prop_coords = proto.createList("coords", -1);
  };
  public StateTupel() {
    this(net.java.html.BrwsrCtx.findDefault(StateTupel.class));
  };
  public StateTupel(java.lang.String aId, int aDiameter, java.lang.String aColor, Transition... aTransitions) {
    this(net.java.html.BrwsrCtx.findDefault(StateTupel.class));
    this.prop_id = aId;
    this.prop_diameter = aDiameter;
    this.prop_color = aColor;
    proto.initTo(this.prop_transitions, aTransitions);
  };
  private static class Html4JavaType extends org.netbeans.html.json.spi.Proto.Type<StateTupel> {
    private Html4JavaType() {
      super(StateTupel.class, UIModel.stateTupelModel.class, 5, 2);
      registerProperty("id", 0, false);
      registerProperty("transitions", 1, false);
      registerProperty("coords", 2, false);
      registerProperty("diameter", 3, false);
      registerProperty("color", 4, false);
      registerFunction("removeTransition", 0);
      registerFunction("addTransition", 1);
    }
    @Override public void setValue(StateTupel data, int type, Object value) {
      switch (type) {
        case 0: data.setId(TYPE.extractValue(java.lang.String.class, value)); return;
        case 1: TYPE.replaceValue(data.getTransitions(), Transition.class, value); return;
        case 2: TYPE.replaceValue(data.getCoords(), java.lang.Integer.class, value); return;
        case 3: data.setDiameter(TYPE.extractValue(java.lang.Integer.class, value)); return;
        case 4: data.setColor(TYPE.extractValue(java.lang.String.class, value)); return;
      }
      throw new UnsupportedOperationException();
    }
    @Override public Object getValue(StateTupel data, int type) {
      switch (type) {
        case 0: return data.getId();
        case 1: return data.getTransitions();
        case 2: return data.getCoords();
        case 3: return data.getDiameter();
        case 4: return data.getColor();
      }
      throw new UnsupportedOperationException();
    }
    @Override public void call(StateTupel model, int type, Object data, Object ev) throws Exception {
      switch (type) {
        case 0:
          com.dukescript.demoapp.UIModel.stateTupelModel.removeTransition(model);
          return;
        case 1:
          com.dukescript.demoapp.UIModel.stateTupelModel.addTransition(model);
          return;
      }
      throw new UnsupportedOperationException();
    }
    @Override public org.netbeans.html.json.spi.Proto protoFor(Object obj) {
      return ((StateTupel)obj).proto;    }
    @Override public void onChange(StateTupel model, int type) {
      switch (type) {
    }
      throw new UnsupportedOperationException();
    }
  @Override public void onMessage(StateTupel model, int index, int type, Object data, Object[] params) {
    switch (index) {
    }
    throw new UnsupportedOperationException("index: " + index + " type: " + type);
  }
    @Override public StateTupel read(net.java.html.BrwsrCtx c, Object json) { return new StateTupel(c, json); }
    @Override public StateTupel cloneTo(StateTupel o, net.java.html.BrwsrCtx c) { return o.clone(c); }
  }
  private StateTupel(net.java.html.BrwsrCtx c, Object json) {
    this(c);
    Object[] ret = new Object[5];
    proto.extract(json, new String[] {
      "id",
      "transitions",
      "coords",
      "diameter",
      "color",
    }, ret);
    this.prop_id = (java.lang.String)ret[0];
    for (Object e : useAsArray(ret[1])) {
      this.prop_transitions.add(proto.read(Transition.class, e));
    }
    for (Object e : useAsArray(ret[2])) {
        this.prop_coords.add(TYPE.numberValue(e).intValue());
    }
    this.prop_diameter = ret[3] == null ? 0 : (TYPE.numberValue(ret[3])).intValue();
    this.prop_color = (java.lang.String)ret[4];
  }
  private static Object[] useAsArray(Object o) {
    return o instanceof Object[] ? ((Object[])o) : o == null ? new Object[0] : new Object[] { o };
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('{');
    sb.append('"').append("id").append('"').append(":");
    sb.append(TYPE.toJSON(prop_id));
    sb.append(',');
    sb.append('"').append("transitions").append('"').append(":");
    sb.append(TYPE.toJSON(prop_transitions));
    sb.append(',');
    sb.append('"').append("coords").append('"').append(":");
    sb.append(TYPE.toJSON(prop_coords));
    sb.append(',');
    sb.append('"').append("diameter").append('"').append(":");
    sb.append(TYPE.toJSON(prop_diameter));
    sb.append(',');
    sb.append('"').append("color").append('"').append(":");
    sb.append(TYPE.toJSON(prop_color));
    sb.append('}');
    return sb.toString();
  }
  public StateTupel clone() {
    return clone(proto.getContext());
  }
  private StateTupel clone(net.java.html.BrwsrCtx ctx) {
    StateTupel ret = new StateTupel(ctx);
    ret.prop_id = getId();
    proto.cloneList(ret.getTransitions(), ctx, prop_transitions);
    proto.cloneList(ret.getCoords(), ctx, prop_coords);
    ret.prop_diameter = getDiameter();
    ret.prop_color = getColor();
    return ret;
  }
  /** Activates this model instance in the current {@link 
net.java.html.json.Models#bind(java.lang.Object, net.java.html.BrwsrCtx) browser context}. 
In case of using Knockout technology, this means to 
bind JSON like data in this model instance with Knockout tags in 
the surrounding HTML page.
This method binds to element '""' on the page
@return <code>this</code> object
*/
  public StateTupel applyBindings() {
    proto.applyBindings();
    return this;
  }
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof StateTupel)) return false;
    StateTupel p = (StateTupel)o;
    if (!TYPE.isSame(prop_id, p.prop_id)) return false;
    if (!TYPE.isSame(prop_transitions, p.prop_transitions)) return false;
    if (!TYPE.isSame(prop_coords, p.prop_coords)) return false;
    if (!TYPE.isSame(prop_diameter, p.prop_diameter)) return false;
    if (!TYPE.isSame(prop_color, p.prop_color)) return false;
    return true;
  }
  public int hashCode() {
    int h = StateTupel.class.getName().hashCode();
    h = TYPE.hashPlus(prop_id, h);
    h = TYPE.hashPlus(prop_transitions, h);
    h = TYPE.hashPlus(prop_coords, h);
    h = TYPE.hashPlus(prop_diameter, h);
    h = TYPE.hashPlus(prop_color, h);
    return h;
  }
}
