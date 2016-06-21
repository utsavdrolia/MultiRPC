package org.crowd.rpc;// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: multirpcProto.proto

public final class RPCProto {
  private RPCProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface RPCReqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:RPCReq)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required uint32 reqID = 1;</code>
     */
    boolean hasReqID();
    /**
     * <code>required uint32 reqID = 1;</code>
     */
    int getReqID();

    /**
     * <code>required string serviceName = 2;</code>
     */
    boolean hasServiceName();
    /**
     * <code>required string serviceName = 2;</code>
     */
    String getServiceName();
    /**
     * <code>required string serviceName = 2;</code>
     */
    com.google.protobuf.ByteString
        getServiceNameBytes();

    /**
     * <code>required uint32 methodID = 3;</code>
     */
    boolean hasMethodID();
    /**
     * <code>required uint32 methodID = 3;</code>
     */
    int getMethodID();

    /**
     * <code>required bytes args = 4;</code>
     */
    boolean hasArgs();
    /**
     * <code>required bytes args = 4;</code>
     */
    com.google.protobuf.ByteString getArgs();
  }
  /**
   * Protobuf type {@code RPCReq}
   */
  public  static final class RPCReq extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:RPCReq)
      RPCReqOrBuilder {
    // Use RPCReq.newBuilder() to construct.
    private RPCReq(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
    }
    private RPCReq() {
      reqID_ = 0;
      serviceName_ = "";
      methodID_ = 0;
      args_ = com.google.protobuf.ByteString.EMPTY;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private RPCReq(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
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
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              reqID_ = input.readUInt32();
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              serviceName_ = bs;
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              methodID_ = input.readUInt32();
              break;
            }
            case 34: {
              bitField0_ |= 0x00000008;
              args_ = input.readBytes();
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
      return RPCProto.internal_static_RPCReq_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return RPCProto.internal_static_RPCReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              RPCReq.class, Builder.class);
    }

    private int bitField0_;
    public static final int REQID_FIELD_NUMBER = 1;
    private int reqID_;
    /**
     * <code>required uint32 reqID = 1;</code>
     */
    public boolean hasReqID() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required uint32 reqID = 1;</code>
     */
    public int getReqID() {
      return reqID_;
    }

    public static final int SERVICENAME_FIELD_NUMBER = 2;
    private volatile Object serviceName_;
    /**
     * <code>required string serviceName = 2;</code>
     */
    public boolean hasServiceName() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string serviceName = 2;</code>
     */
    public String getServiceName() {
      Object ref = serviceName_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          serviceName_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string serviceName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getServiceNameBytes() {
      Object ref = serviceName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        serviceName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int METHODID_FIELD_NUMBER = 3;
    private int methodID_;
    /**
     * <code>required uint32 methodID = 3;</code>
     */
    public boolean hasMethodID() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required uint32 methodID = 3;</code>
     */
    public int getMethodID() {
      return methodID_;
    }

    public static final int ARGS_FIELD_NUMBER = 4;
    private com.google.protobuf.ByteString args_;
    /**
     * <code>required bytes args = 4;</code>
     */
    public boolean hasArgs() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required bytes args = 4;</code>
     */
    public com.google.protobuf.ByteString getArgs() {
      return args_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasReqID()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasServiceName()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasMethodID()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasArgs()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeUInt32(1, reqID_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        com.google.protobuf.GeneratedMessage.writeString(output, 2, serviceName_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeUInt32(3, methodID_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeBytes(4, args_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(1, reqID_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.GeneratedMessage.computeStringSize(2, serviceName_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(3, methodID_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, args_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    public static RPCReq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static RPCReq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static RPCReq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static RPCReq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static RPCReq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static RPCReq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static RPCReq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static RPCReq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static RPCReq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static RPCReq parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(RPCReq prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code RPCReq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:RPCReq)
        RPCReqOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return RPCProto.internal_static_RPCReq_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return RPCProto.internal_static_RPCReq_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                RPCReq.class, Builder.class);
      }

      // Construct using RPCProto.RPCReq.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        reqID_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        serviceName_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        methodID_ = 0;
        bitField0_ = (bitField0_ & ~0x00000004);
        args_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return RPCProto.internal_static_RPCReq_descriptor;
      }

      public RPCReq getDefaultInstanceForType() {
        return RPCReq.getDefaultInstance();
      }

      public RPCReq build() {
        RPCReq result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public RPCReq buildPartial() {
        RPCReq result = new RPCReq(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.reqID_ = reqID_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.serviceName_ = serviceName_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.methodID_ = methodID_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.args_ = args_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof RPCReq) {
          return mergeFrom((RPCReq)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(RPCReq other) {
        if (other == RPCReq.getDefaultInstance()) return this;
        if (other.hasReqID()) {
          setReqID(other.getReqID());
        }
        if (other.hasServiceName()) {
          bitField0_ |= 0x00000002;
          serviceName_ = other.serviceName_;
          onChanged();
        }
        if (other.hasMethodID()) {
          setMethodID(other.getMethodID());
        }
        if (other.hasArgs()) {
          setArgs(other.getArgs());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasReqID()) {
          return false;
        }
        if (!hasServiceName()) {
          return false;
        }
        if (!hasMethodID()) {
          return false;
        }
        if (!hasArgs()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        RPCReq parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (RPCReq) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int reqID_ ;
      /**
       * <code>required uint32 reqID = 1;</code>
       */
      public boolean hasReqID() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required uint32 reqID = 1;</code>
       */
      public int getReqID() {
        return reqID_;
      }
      /**
       * <code>required uint32 reqID = 1;</code>
       */
      public Builder setReqID(int value) {
        bitField0_ |= 0x00000001;
        reqID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint32 reqID = 1;</code>
       */
      public Builder clearReqID() {
        bitField0_ = (bitField0_ & ~0x00000001);
        reqID_ = 0;
        onChanged();
        return this;
      }

      private Object serviceName_ = "";
      /**
       * <code>required string serviceName = 2;</code>
       */
      public boolean hasServiceName() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string serviceName = 2;</code>
       */
      public String getServiceName() {
        Object ref = serviceName_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            serviceName_ = s;
          }
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>required string serviceName = 2;</code>
       */
      public com.google.protobuf.ByteString
          getServiceNameBytes() {
        Object ref = serviceName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          serviceName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string serviceName = 2;</code>
       */
      public Builder setServiceName(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        serviceName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string serviceName = 2;</code>
       */
      public Builder clearServiceName() {
        bitField0_ = (bitField0_ & ~0x00000002);
        serviceName_ = getDefaultInstance().getServiceName();
        onChanged();
        return this;
      }
      /**
       * <code>required string serviceName = 2;</code>
       */
      public Builder setServiceNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        serviceName_ = value;
        onChanged();
        return this;
      }

      private int methodID_ ;
      /**
       * <code>required uint32 methodID = 3;</code>
       */
      public boolean hasMethodID() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required uint32 methodID = 3;</code>
       */
      public int getMethodID() {
        return methodID_;
      }
      /**
       * <code>required uint32 methodID = 3;</code>
       */
      public Builder setMethodID(int value) {
        bitField0_ |= 0x00000004;
        methodID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint32 methodID = 3;</code>
       */
      public Builder clearMethodID() {
        bitField0_ = (bitField0_ & ~0x00000004);
        methodID_ = 0;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString args_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes args = 4;</code>
       */
      public boolean hasArgs() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required bytes args = 4;</code>
       */
      public com.google.protobuf.ByteString getArgs() {
        return args_;
      }
      /**
       * <code>required bytes args = 4;</code>
       */
      public Builder setArgs(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        args_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes args = 4;</code>
       */
      public Builder clearArgs() {
        bitField0_ = (bitField0_ & ~0x00000008);
        args_ = getDefaultInstance().getArgs();
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:RPCReq)
    }

    // @@protoc_insertion_point(class_scope:RPCReq)
    private static final RPCReq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new RPCReq();
    }

    public static RPCReq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @Deprecated public static final com.google.protobuf.Parser<RPCReq>
        PARSER = new com.google.protobuf.AbstractParser<RPCReq>() {
      public RPCReq parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new RPCReq(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<RPCReq> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<RPCReq> getParserForType() {
      return PARSER;
    }

    public RPCReq getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface RPCRespOrBuilder extends
      // @@protoc_insertion_point(interface_extends:RPCResp)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required uint32 reqID = 1;</code>
     */
    boolean hasReqID();
    /**
     * <code>required uint32 reqID = 1;</code>
     */
    int getReqID();

    /**
     * <code>required bytes results = 2;</code>
     */
    boolean hasResults();
    /**
     * <code>required bytes results = 2;</code>
     */
    com.google.protobuf.ByteString getResults();
  }
  /**
   * Protobuf type {@code RPCResp}
   */
  public  static final class RPCResp extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:RPCResp)
      RPCRespOrBuilder {
    // Use RPCResp.newBuilder() to construct.
    private RPCResp(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
    }
    private RPCResp() {
      reqID_ = 0;
      results_ = com.google.protobuf.ByteString.EMPTY;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private RPCResp(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
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
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              reqID_ = input.readUInt32();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              results_ = input.readBytes();
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
      return RPCProto.internal_static_RPCResp_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return RPCProto.internal_static_RPCResp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              RPCResp.class, Builder.class);
    }

    private int bitField0_;
    public static final int REQID_FIELD_NUMBER = 1;
    private int reqID_;
    /**
     * <code>required uint32 reqID = 1;</code>
     */
    public boolean hasReqID() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required uint32 reqID = 1;</code>
     */
    public int getReqID() {
      return reqID_;
    }

    public static final int RESULTS_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString results_;
    /**
     * <code>required bytes results = 2;</code>
     */
    public boolean hasResults() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required bytes results = 2;</code>
     */
    public com.google.protobuf.ByteString getResults() {
      return results_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasReqID()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasResults()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeUInt32(1, reqID_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, results_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(1, reqID_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, results_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    public static RPCResp parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static RPCResp parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static RPCResp parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static RPCResp parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static RPCResp parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static RPCResp parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static RPCResp parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static RPCResp parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static RPCResp parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input);
    }
    public static RPCResp parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(RPCResp prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code RPCResp}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:RPCResp)
        RPCRespOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return RPCProto.internal_static_RPCResp_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return RPCProto.internal_static_RPCResp_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                RPCResp.class, Builder.class);
      }

      // Construct using RPCProto.RPCResp.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        reqID_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        results_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return RPCProto.internal_static_RPCResp_descriptor;
      }

      public RPCResp getDefaultInstanceForType() {
        return RPCResp.getDefaultInstance();
      }

      public RPCResp build() {
        RPCResp result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public RPCResp buildPartial() {
        RPCResp result = new RPCResp(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.reqID_ = reqID_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.results_ = results_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof RPCResp) {
          return mergeFrom((RPCResp)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(RPCResp other) {
        if (other == RPCResp.getDefaultInstance()) return this;
        if (other.hasReqID()) {
          setReqID(other.getReqID());
        }
        if (other.hasResults()) {
          setResults(other.getResults());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasReqID()) {
          return false;
        }
        if (!hasResults()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        RPCResp parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (RPCResp) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int reqID_ ;
      /**
       * <code>required uint32 reqID = 1;</code>
       */
      public boolean hasReqID() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required uint32 reqID = 1;</code>
       */
      public int getReqID() {
        return reqID_;
      }
      /**
       * <code>required uint32 reqID = 1;</code>
       */
      public Builder setReqID(int value) {
        bitField0_ |= 0x00000001;
        reqID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint32 reqID = 1;</code>
       */
      public Builder clearReqID() {
        bitField0_ = (bitField0_ & ~0x00000001);
        reqID_ = 0;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString results_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes results = 2;</code>
       */
      public boolean hasResults() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required bytes results = 2;</code>
       */
      public com.google.protobuf.ByteString getResults() {
        return results_;
      }
      /**
       * <code>required bytes results = 2;</code>
       */
      public Builder setResults(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        results_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes results = 2;</code>
       */
      public Builder clearResults() {
        bitField0_ = (bitField0_ & ~0x00000002);
        results_ = getDefaultInstance().getResults();
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:RPCResp)
    }

    // @@protoc_insertion_point(class_scope:RPCResp)
    private static final RPCResp DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new RPCResp();
    }

    public static RPCResp getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @Deprecated public static final com.google.protobuf.Parser<RPCResp>
        PARSER = new com.google.protobuf.AbstractParser<RPCResp>() {
      public RPCResp parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new RPCResp(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<RPCResp> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<RPCResp> getParserForType() {
      return PARSER;
    }

    public RPCResp getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RPCReq_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_RPCReq_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RPCResp_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_RPCResp_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\023multirpcProto.proto\"L\n\006RPCReq\022\r\n\005reqID" +
      "\030\001 \002(\r\022\023\n\013serviceName\030\002 \002(\t\022\020\n\010methodID\030" +
      "\003 \002(\r\022\014\n\004args\030\004 \002(\014\")\n\007RPCResp\022\r\n\005reqID\030" +
      "\001 \002(\r\022\017\n\007results\030\002 \002(\014B\nB\010RPCProto"
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
    internal_static_RPCReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_RPCReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_RPCReq_descriptor,
        new String[] { "ReqID", "ServiceName", "MethodID", "Args", });
    internal_static_RPCResp_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_RPCResp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_RPCResp_descriptor,
        new String[] { "ReqID", "Results", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
