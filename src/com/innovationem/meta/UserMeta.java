package com.innovationem.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-02-24 11:35:21")
/** */
public final class UserMeta extends org.slim3.datastore.ModelMeta<com.innovationem.model.User> {

    /** */
    public final org.slim3.datastore.CoreUnindexedAttributeMeta<com.innovationem.model.User, java.lang.Boolean> active = new org.slim3.datastore.CoreUnindexedAttributeMeta<com.innovationem.model.User, java.lang.Boolean>(this, "active", "active", java.lang.Boolean.class);

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<com.innovationem.model.User> country = new org.slim3.datastore.StringUnindexedAttributeMeta<com.innovationem.model.User>(this, "country", "country");

    /** */
    public final org.slim3.datastore.CoreUnindexedAttributeMeta<com.innovationem.model.User, java.util.Date> createDate = new org.slim3.datastore.CoreUnindexedAttributeMeta<com.innovationem.model.User, java.util.Date>(this, "createDate", "createDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.innovationem.model.User> email = new org.slim3.datastore.StringAttributeMeta<com.innovationem.model.User>(this, "email", "email");

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<com.innovationem.model.User> fullName = new org.slim3.datastore.StringUnindexedAttributeMeta<com.innovationem.model.User>(this, "fullName", "fullName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.innovationem.model.User, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.innovationem.model.User, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreUnindexedAttributeMeta<com.innovationem.model.User, java.util.Date> lastLoginTime = new org.slim3.datastore.CoreUnindexedAttributeMeta<com.innovationem.model.User, java.util.Date>(this, "lastLoginTime", "lastLoginTime", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<com.innovationem.model.User> state = new org.slim3.datastore.StringUnindexedAttributeMeta<com.innovationem.model.User>(this, "state", "state");

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<com.innovationem.model.User> theme = new org.slim3.datastore.StringUnindexedAttributeMeta<com.innovationem.model.User>(this, "theme", "theme");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.innovationem.model.User, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.innovationem.model.User, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<com.innovationem.model.User> zip = new org.slim3.datastore.StringUnindexedAttributeMeta<com.innovationem.model.User>(this, "zip", "zip");

    private static final UserMeta slim3_singleton = new UserMeta();

    /**
     * @return the singleton
     */
    public static UserMeta get() {
       return slim3_singleton;
    }

    /** */
    public UserMeta() {
        super("User", com.innovationem.model.User.class);
    }

    @Override
    public com.innovationem.model.User entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.innovationem.model.User model = new com.innovationem.model.User();
        model.setActive((java.lang.Boolean) entity.getProperty("active"));
        model.setCountry((java.lang.String) entity.getProperty("country"));
        model.setCreateDate((java.util.Date) entity.getProperty("createDate"));
        model.setEmail((java.lang.String) entity.getProperty("email"));
        model.setFullName((java.lang.String) entity.getProperty("fullName"));
        model.setKey(entity.getKey());
        model.setLastLoginTime((java.util.Date) entity.getProperty("lastLoginTime"));
        model.setState((java.lang.String) entity.getProperty("state"));
        model.setTheme((java.lang.String) entity.getProperty("theme"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        model.setZip((java.lang.String) entity.getProperty("zip"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.innovationem.model.User m = (com.innovationem.model.User) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setUnindexedProperty("active", m.getActive());
        entity.setUnindexedProperty("country", m.getCountry());
        entity.setUnindexedProperty("createDate", m.getCreateDate());
        entity.setProperty("email", m.getEmail());
        entity.setUnindexedProperty("fullName", m.getFullName());
        entity.setUnindexedProperty("lastLoginTime", m.getLastLoginTime());
        entity.setUnindexedProperty("state", m.getState());
        entity.setUnindexedProperty("theme", m.getTheme());
        entity.setProperty("version", m.getVersion());
        entity.setUnindexedProperty("zip", m.getZip());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.innovationem.model.User m = (com.innovationem.model.User) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.innovationem.model.User m = (com.innovationem.model.User) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.innovationem.model.User m = (com.innovationem.model.User) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.innovationem.model.User m = (com.innovationem.model.User) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        com.innovationem.model.User m = (com.innovationem.model.User) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getActive() != null){
            writer.setNextPropertyName("active");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getActive());
        }
        if(m.getCountry() != null){
            writer.setNextPropertyName("country");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getCountry());
        }
        if(m.getCreateDate() != null){
            writer.setNextPropertyName("createDate");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getCreateDate());
        }
        if(m.getEmail() != null){
            writer.setNextPropertyName("email");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getEmail());
        }
        if(m.getFullName() != null){
            writer.setNextPropertyName("fullName");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getFullName());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getLastLoginTime() != null){
            writer.setNextPropertyName("lastLoginTime");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getLastLoginTime());
        }
        if(m.getState() != null){
            writer.setNextPropertyName("state");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getState());
        }
        if(m.getTheme() != null){
            writer.setNextPropertyName("theme");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getTheme());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getVersion());
        }
        if(m.getZip() != null){
            writer.setNextPropertyName("zip");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getZip());
        }
        writer.endObject();
    }

    @Override
    public com.innovationem.model.User jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.innovationem.model.User m = new com.innovationem.model.User();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("active");
        decoder = new org.slim3.datastore.json.Default();
        m.setActive(decoder.decode(reader, m.getActive()));
        reader = rootReader.newObjectReader("country");
        decoder = new org.slim3.datastore.json.Default();
        m.setCountry(decoder.decode(reader, m.getCountry()));
        reader = rootReader.newObjectReader("createDate");
        decoder = new org.slim3.datastore.json.Default();
        m.setCreateDate(decoder.decode(reader, m.getCreateDate()));
        reader = rootReader.newObjectReader("email");
        decoder = new org.slim3.datastore.json.Default();
        m.setEmail(decoder.decode(reader, m.getEmail()));
        reader = rootReader.newObjectReader("fullName");
        decoder = new org.slim3.datastore.json.Default();
        m.setFullName(decoder.decode(reader, m.getFullName()));
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("lastLoginTime");
        decoder = new org.slim3.datastore.json.Default();
        m.setLastLoginTime(decoder.decode(reader, m.getLastLoginTime()));
        reader = rootReader.newObjectReader("state");
        decoder = new org.slim3.datastore.json.Default();
        m.setState(decoder.decode(reader, m.getState()));
        reader = rootReader.newObjectReader("theme");
        decoder = new org.slim3.datastore.json.Default();
        m.setTheme(decoder.decode(reader, m.getTheme()));
        reader = rootReader.newObjectReader("version");
        decoder = new org.slim3.datastore.json.Default();
        m.setVersion(decoder.decode(reader, m.getVersion()));
        reader = rootReader.newObjectReader("zip");
        decoder = new org.slim3.datastore.json.Default();
        m.setZip(decoder.decode(reader, m.getZip()));
    return m;
}
}