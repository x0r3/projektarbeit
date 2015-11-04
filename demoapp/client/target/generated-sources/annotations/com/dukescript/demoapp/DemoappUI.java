package com.dukescript.demoapp;
import net.java.html.json.*;
public final class DemoappUI implements Cloneable {
  private static final Html4JavaType TYPE = new Html4JavaType();
  private final org.netbeans.html.json.spi.Proto proto;
  public java.util.List<java.lang.String> getWords() {
    java.lang.String arg1 = getInfoMessage();
    try {
      proto.acquireLock();
      return com.dukescript.demoapp.DemoppUIController.words(arg1);
    } finally {
      proto.releaseLock();
    }
  }
  private java.lang.String prop_infoMessage;
  public java.lang.String getInfoMessage() {
    proto.accessProperty("infoMessage");
    return prop_infoMessage;
  }
  public void setInfoMessage(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_infoMessage;
    if (TYPE.isSame(o , v)) return;
    prop_infoMessage = v;
    proto.valueHasMutated("infoMessage", o, v);
    proto.valueHasMutated("words", null, getWords());
  }
  private boolean prop_rotating;
  public boolean isRotating() {
    proto.accessProperty("rotating");
    return prop_rotating;
  }
  public void setRotating(boolean v) {
    proto.verifyUnlocked();
    Object o = prop_rotating;
    if (TYPE.isSame(o , v)) return;
    prop_rotating = v;
    proto.valueHasMutated("rotating", o, v);
  }
  private int prop_first;
  public int getFirst() {
    proto.accessProperty("first");
    return prop_first;
  }
  public void setFirst(int v) {
    proto.verifyUnlocked();
    Object o = prop_first;
    if (TYPE.isSame(o , v)) return;
    prop_first = v;
    proto.valueHasMutated("first", o, v);
  }
  private int prop_second;
  public int getSecond() {
    proto.accessProperty("second");
    return prop_second;
  }
  public void setSecond(int v) {
    proto.verifyUnlocked();
    Object o = prop_second;
    if (TYPE.isSame(o , v)) return;
    prop_second = v;
    proto.valueHasMutated("second", o, v);
  }
  private static Class<DemoppUIController> modelFor() { return null; }
  private DemoappUI(net.java.html.BrwsrCtx context) {
    this.proto = TYPE.createProto(this, context);
  };
  public DemoappUI() {
    this(net.java.html.BrwsrCtx.findDefault(DemoappUI.class));
  };
  public DemoappUI(java.lang.String aInfoMessage, boolean aRotating, int aFirst, int aSecond) {
    this(net.java.html.BrwsrCtx.findDefault(DemoappUI.class));
    this.prop_infoMessage = aInfoMessage;
    this.prop_rotating = aRotating;
    this.prop_first = aFirst;
    this.prop_second = aSecond;
  };
  private static class Html4JavaType extends org.netbeans.html.json.spi.Proto.Type<DemoappUI> {
    private Html4JavaType() {
      super(DemoappUI.class, DemoppUIController.class, 5, 6);
      registerProperty("words", 0, true);
      registerProperty("infoMessage", 1, false);
      registerProperty("rotating", 2, false);
      registerProperty("first", 3, false);
      registerProperty("second", 4, false);
      registerFunction("resizeCanvas", 0);
      registerFunction("turnAnimationOn", 1);
      registerFunction("turnAnimationOff", 2);
      registerFunction("rotate5s", 3);
      registerFunction("showScreenSize", 4);
      registerFunction("drawSmallerRect", 5);
    }
    @Override public void setValue(DemoappUI data, int type, Object value) {
      switch (type) {
        case 1: data.setInfoMessage(TYPE.extractValue(java.lang.String.class, value)); return;
        case 2: data.setRotating(TYPE.extractValue(java.lang.Boolean.class, value)); return;
        case 3: data.setFirst(TYPE.extractValue(java.lang.Integer.class, value)); return;
        case 4: data.setSecond(TYPE.extractValue(java.lang.Integer.class, value)); return;
      }
      throw new UnsupportedOperationException();
    }
    @Override public Object getValue(DemoappUI data, int type) {
      switch (type) {
        case 0: return data.getWords();
        case 1: return data.getInfoMessage();
        case 2: return data.isRotating();
        case 3: return data.getFirst();
        case 4: return data.getSecond();
      }
      throw new UnsupportedOperationException();
    }
    @Override public void call(DemoappUI model, int type, Object data, Object ev) throws Exception {
      switch (type) {
        case 0:
          com.dukescript.demoapp.DemoppUIController.resizeCanvas();
          return;
        case 1:
          com.dukescript.demoapp.DemoppUIController.turnAnimationOn(model);
          return;
        case 2:
          com.dukescript.demoapp.DemoppUIController.turnAnimationOff(model);
          return;
        case 3:
          com.dukescript.demoapp.DemoppUIController.rotate5s(model);
          return;
        case 4:
          com.dukescript.demoapp.DemoppUIController.showScreenSize(model);
          return;
        case 5:
          com.dukescript.demoapp.DemoppUIController.drawSmallerRect(model);
          return;
      }
      throw new UnsupportedOperationException();
    }
    @Override public org.netbeans.html.json.spi.Proto protoFor(Object obj) {
      return ((DemoappUI)obj).proto;    }
    @Override public void onChange(DemoappUI model, int type) {
      switch (type) {
    }
      throw new UnsupportedOperationException();
    }
  @Override public void onMessage(DemoappUI model, int index, int type, Object data, Object[] params) {
    switch (index) {
    }
    throw new UnsupportedOperationException("index: " + index + " type: " + type);
  }
    @Override public DemoappUI read(net.java.html.BrwsrCtx c, Object json) { return new DemoappUI(c, json); }
    @Override public DemoappUI cloneTo(DemoappUI o, net.java.html.BrwsrCtx c) { return o.clone(c); }
  }
  private DemoappUI(net.java.html.BrwsrCtx c, Object json) {
    this(c);
    Object[] ret = new Object[4];
    proto.extract(json, new String[] {
      "infoMessage",
      "rotating",
      "first",
      "second",
    }, ret);
    this.prop_infoMessage = (java.lang.String)ret[0];
    this.prop_rotating = ret[1] == null ? false : (TYPE.boolValue(ret[1])).booleanValue();
    this.prop_first = ret[2] == null ? 0 : (TYPE.numberValue(ret[2])).intValue();
    this.prop_second = ret[3] == null ? 0 : (TYPE.numberValue(ret[3])).intValue();
  }
  private static Object[] useAsArray(Object o) {
    return o instanceof Object[] ? ((Object[])o) : o == null ? new Object[0] : new Object[] { o };
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('{');
    sb.append('"').append("infoMessage").append('"').append(":");
    sb.append(TYPE.toJSON(prop_infoMessage));
    sb.append(',');
    sb.append('"').append("rotating").append('"').append(":");
    sb.append(TYPE.toJSON(prop_rotating));
    sb.append(',');
    sb.append('"').append("first").append('"').append(":");
    sb.append(TYPE.toJSON(prop_first));
    sb.append(',');
    sb.append('"').append("second").append('"').append(":");
    sb.append(TYPE.toJSON(prop_second));
    sb.append('}');
    return sb.toString();
  }
  public DemoappUI clone() {
    return clone(proto.getContext());
  }
  private DemoappUI clone(net.java.html.BrwsrCtx ctx) {
    DemoappUI ret = new DemoappUI(ctx);
    ret.prop_infoMessage = getInfoMessage();
    ret.prop_rotating = isRotating();
    ret.prop_first = getFirst();
    ret.prop_second = getSecond();
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
  public DemoappUI applyBindings() {
    proto.applyBindings();
    return this;
  }
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof DemoappUI)) return false;
    DemoappUI p = (DemoappUI)o;
    if (!TYPE.isSame(prop_infoMessage, p.prop_infoMessage)) return false;
    if (!TYPE.isSame(prop_rotating, p.prop_rotating)) return false;
    if (!TYPE.isSame(prop_first, p.prop_first)) return false;
    if (!TYPE.isSame(prop_second, p.prop_second)) return false;
    return true;
  }
  public int hashCode() {
    int h = DemoappUI.class.getName().hashCode();
    h = TYPE.hashPlus(prop_infoMessage, h);
    h = TYPE.hashPlus(prop_rotating, h);
    h = TYPE.hashPlus(prop_first, h);
    h = TYPE.hashPlus(prop_second, h);
    return h;
  }
}
