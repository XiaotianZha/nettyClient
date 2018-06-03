// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: heartbeat.proto

package com.zhang.protobuf.model;

public final class HeartBeatProto {
  private HeartBeatProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface HeartBeatOrBuilder extends
      // @@protoc_insertion_point(interface_extends:model.HeartBeat)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required string id = 1;</code>
     */
    boolean hasId();
    /**
     * <code>required string id = 1;</code>
     */
    java.lang.String getId();
    /**
     * <code>required string id = 1;</code>
     */
    com.google.protobuf.ByteString
        getIdBytes();

    /**
     * <code>required string msg = 2 [default = "hello"];</code>
     */
    boolean hasMsg();
    /**
     * <code>required string msg = 2 [default = "hello"];</code>
     */
    java.lang.String getMsg();
    /**
     * <code>required string msg = 2 [default = "hello"];</code>
     */
    com.google.protobuf.ByteString
        getMsgBytes();

    /**
     * <code>optional string remark = 3;</code>
     */
    boolean hasRemark();
    /**
     * <code>optional string remark = 3;</code>
     */
    java.lang.String getRemark();
    /**
     * <code>optional string remark = 3;</code>
     */
    com.google.protobuf.ByteString
        getRemarkBytes();
  }
  /**
   * Protobuf type {@code model.HeartBeat}
   */
  public  static final class HeartBeat extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:model.HeartBeat)
      HeartBeatOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use HeartBeat.newBuilder() to construct.
    private HeartBeat(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private HeartBeat() {
      id_ = "";
      msg_ = "hello";
      remark_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private HeartBeat(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              id_ = bs;
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              msg_ = bs;
              break;
            }
            case 26: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000004;
              remark_ = bs;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.zhang.protobuf.model.HeartBeatProto.internal_static_model_HeartBeat_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.zhang.protobuf.model.HeartBeatProto.internal_static_model_HeartBeat_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.zhang.protobuf.model.HeartBeatProto.HeartBeat.class, com.zhang.protobuf.model.HeartBeatProto.HeartBeat.Builder.class);
    }

    private int bitField0_;
    public static final int ID_FIELD_NUMBER = 1;
    private volatile java.lang.Object id_;
    /**
     * <code>required string id = 1;</code>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string id = 1;</code>
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          id_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MSG_FIELD_NUMBER = 2;
    private volatile java.lang.Object msg_;
    /**
     * <code>required string msg = 2 [default = "hello"];</code>
     */
    public boolean hasMsg() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string msg = 2 [default = "hello"];</code>
     */
    public java.lang.String getMsg() {
      java.lang.Object ref = msg_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          msg_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string msg = 2 [default = "hello"];</code>
     */
    public com.google.protobuf.ByteString
        getMsgBytes() {
      java.lang.Object ref = msg_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        msg_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int REMARK_FIELD_NUMBER = 3;
    private volatile java.lang.Object remark_;
    /**
     * <code>optional string remark = 3;</code>
     */
    public boolean hasRemark() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional string remark = 3;</code>
     */
    public java.lang.String getRemark() {
      java.lang.Object ref = remark_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          remark_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string remark = 3;</code>
     */
    public com.google.protobuf.ByteString
        getRemarkBytes() {
      java.lang.Object ref = remark_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        remark_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasMsg()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, msg_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, remark_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, msg_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, remark_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.zhang.protobuf.model.HeartBeatProto.HeartBeat)) {
        return super.equals(obj);
      }
      com.zhang.protobuf.model.HeartBeatProto.HeartBeat other = (com.zhang.protobuf.model.HeartBeatProto.HeartBeat) obj;

      boolean result = true;
      result = result && (hasId() == other.hasId());
      if (hasId()) {
        result = result && getId()
            .equals(other.getId());
      }
      result = result && (hasMsg() == other.hasMsg());
      if (hasMsg()) {
        result = result && getMsg()
            .equals(other.getMsg());
      }
      result = result && (hasRemark() == other.hasRemark());
      if (hasRemark()) {
        result = result && getRemark()
            .equals(other.getRemark());
      }
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasId()) {
        hash = (37 * hash) + ID_FIELD_NUMBER;
        hash = (53 * hash) + getId().hashCode();
      }
      if (hasMsg()) {
        hash = (37 * hash) + MSG_FIELD_NUMBER;
        hash = (53 * hash) + getMsg().hashCode();
      }
      if (hasRemark()) {
        hash = (37 * hash) + REMARK_FIELD_NUMBER;
        hash = (53 * hash) + getRemark().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.zhang.protobuf.model.HeartBeatProto.HeartBeat parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.zhang.protobuf.model.HeartBeatProto.HeartBeat parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.zhang.protobuf.model.HeartBeatProto.HeartBeat parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.zhang.protobuf.model.HeartBeatProto.HeartBeat parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.zhang.protobuf.model.HeartBeatProto.HeartBeat parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.zhang.protobuf.model.HeartBeatProto.HeartBeat parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.zhang.protobuf.model.HeartBeatProto.HeartBeat parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.zhang.protobuf.model.HeartBeatProto.HeartBeat parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.zhang.protobuf.model.HeartBeatProto.HeartBeat parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.zhang.protobuf.model.HeartBeatProto.HeartBeat parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.zhang.protobuf.model.HeartBeatProto.HeartBeat parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.zhang.protobuf.model.HeartBeatProto.HeartBeat parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.zhang.protobuf.model.HeartBeatProto.HeartBeat prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code model.HeartBeat}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:model.HeartBeat)
        com.zhang.protobuf.model.HeartBeatProto.HeartBeatOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.zhang.protobuf.model.HeartBeatProto.internal_static_model_HeartBeat_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.zhang.protobuf.model.HeartBeatProto.internal_static_model_HeartBeat_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.zhang.protobuf.model.HeartBeatProto.HeartBeat.class, com.zhang.protobuf.model.HeartBeatProto.HeartBeat.Builder.class);
      }

      // Construct using com.zhang.protobuf.model.HeartBeatProto.HeartBeat.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        id_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        msg_ = "hello";
        bitField0_ = (bitField0_ & ~0x00000002);
        remark_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.zhang.protobuf.model.HeartBeatProto.internal_static_model_HeartBeat_descriptor;
      }

      public com.zhang.protobuf.model.HeartBeatProto.HeartBeat getDefaultInstanceForType() {
        return com.zhang.protobuf.model.HeartBeatProto.HeartBeat.getDefaultInstance();
      }

      public com.zhang.protobuf.model.HeartBeatProto.HeartBeat build() {
        com.zhang.protobuf.model.HeartBeatProto.HeartBeat result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.zhang.protobuf.model.HeartBeatProto.HeartBeat buildPartial() {
        com.zhang.protobuf.model.HeartBeatProto.HeartBeat result = new com.zhang.protobuf.model.HeartBeatProto.HeartBeat(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.id_ = id_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.msg_ = msg_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.remark_ = remark_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.zhang.protobuf.model.HeartBeatProto.HeartBeat) {
          return mergeFrom((com.zhang.protobuf.model.HeartBeatProto.HeartBeat)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.zhang.protobuf.model.HeartBeatProto.HeartBeat other) {
        if (other == com.zhang.protobuf.model.HeartBeatProto.HeartBeat.getDefaultInstance()) return this;
        if (other.hasId()) {
          bitField0_ |= 0x00000001;
          id_ = other.id_;
          onChanged();
        }
        if (other.hasMsg()) {
          bitField0_ |= 0x00000002;
          msg_ = other.msg_;
          onChanged();
        }
        if (other.hasRemark()) {
          bitField0_ |= 0x00000004;
          remark_ = other.remark_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasId()) {
          return false;
        }
        if (!hasMsg()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.zhang.protobuf.model.HeartBeatProto.HeartBeat parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.zhang.protobuf.model.HeartBeatProto.HeartBeat) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object id_ = "";
      /**
       * <code>required string id = 1;</code>
       */
      public boolean hasId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string id = 1;</code>
       */
      public java.lang.String getId() {
        java.lang.Object ref = id_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            id_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string id = 1;</code>
       */
      public com.google.protobuf.ByteString
          getIdBytes() {
        java.lang.Object ref = id_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          id_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string id = 1;</code>
       */
      public Builder setId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string id = 1;</code>
       */
      public Builder clearId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        id_ = getDefaultInstance().getId();
        onChanged();
        return this;
      }
      /**
       * <code>required string id = 1;</code>
       */
      public Builder setIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        id_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object msg_ = "hello";
      /**
       * <code>required string msg = 2 [default = "hello"];</code>
       */
      public boolean hasMsg() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string msg = 2 [default = "hello"];</code>
       */
      public java.lang.String getMsg() {
        java.lang.Object ref = msg_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            msg_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string msg = 2 [default = "hello"];</code>
       */
      public com.google.protobuf.ByteString
          getMsgBytes() {
        java.lang.Object ref = msg_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          msg_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string msg = 2 [default = "hello"];</code>
       */
      public Builder setMsg(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        msg_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string msg = 2 [default = "hello"];</code>
       */
      public Builder clearMsg() {
        bitField0_ = (bitField0_ & ~0x00000002);
        msg_ = getDefaultInstance().getMsg();
        onChanged();
        return this;
      }
      /**
       * <code>required string msg = 2 [default = "hello"];</code>
       */
      public Builder setMsgBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        msg_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object remark_ = "";
      /**
       * <code>optional string remark = 3;</code>
       */
      public boolean hasRemark() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional string remark = 3;</code>
       */
      public java.lang.String getRemark() {
        java.lang.Object ref = remark_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            remark_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string remark = 3;</code>
       */
      public com.google.protobuf.ByteString
          getRemarkBytes() {
        java.lang.Object ref = remark_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          remark_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string remark = 3;</code>
       */
      public Builder setRemark(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        remark_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string remark = 3;</code>
       */
      public Builder clearRemark() {
        bitField0_ = (bitField0_ & ~0x00000004);
        remark_ = getDefaultInstance().getRemark();
        onChanged();
        return this;
      }
      /**
       * <code>optional string remark = 3;</code>
       */
      public Builder setRemarkBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        remark_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:model.HeartBeat)
    }

    // @@protoc_insertion_point(class_scope:model.HeartBeat)
    private static final com.zhang.protobuf.model.HeartBeatProto.HeartBeat DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.zhang.protobuf.model.HeartBeatProto.HeartBeat();
    }

    public static com.zhang.protobuf.model.HeartBeatProto.HeartBeat getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<HeartBeat>
        PARSER = new com.google.protobuf.AbstractParser<HeartBeat>() {
      public HeartBeat parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new HeartBeat(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<HeartBeat> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<HeartBeat> getParserForType() {
      return PARSER;
    }

    public com.zhang.protobuf.model.HeartBeatProto.HeartBeat getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_model_HeartBeat_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_model_HeartBeat_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017heartbeat.proto\022\005model\";\n\tHeartBeat\022\n\n" +
      "\002id\030\001 \002(\t\022\022\n\003msg\030\002 \002(\t:\005hello\022\016\n\006remark\030" +
      "\003 \001(\tB*\n\030com.zhang.protobuf.modelB\016Heart" +
      "BeatProto"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_model_HeartBeat_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_model_HeartBeat_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_model_HeartBeat_descriptor,
        new java.lang.String[] { "Id", "Msg", "Remark", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
