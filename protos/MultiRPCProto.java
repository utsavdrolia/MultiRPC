// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: multirpcProto.proto

public final class MultiRPCProto {
  private MultiRPCProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface MultiRPCMsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:MultiRPCMsg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required .MultiRPCMsg.MsgType msgType = 1;</code>
     */
    boolean hasMsgType();
    /**
     * <code>required .MultiRPCMsg.MsgType msgType = 1;</code>
     */
    MultiRPCProto.MultiRPCMsg.MsgType getMsgType();

    /**
     * <code>required uint32 reqID = 2;</code>
     */
    boolean hasReqID();
    /**
     * <code>required uint32 reqID = 2;</code>
     */
    int getReqID();

    /**
     * <code>optional string serviceName = 3;</code>
     */
    boolean hasServiceName();
    /**
     * <code>optional string serviceName = 3;</code>
     */
    java.lang.String getServiceName();
    /**
     * <code>optional string serviceName = 3;</code>
     */
    com.google.protobuf.ByteString
        getServiceNameBytes();

    /**
     * <code>optional uint32 methodID = 4;</code>
     */
    boolean hasMethodID();
    /**
     * <code>optional uint32 methodID = 4;</code>
     */
    int getMethodID();

    /**
     * <code>optional bytes args = 5;</code>
     */
    boolean hasArgs();
    /**
     * <code>optional bytes args = 5;</code>
     */
    com.google.protobuf.ByteString getArgs();

    /**
     * <code>optional bytes results = 6;</code>
     */
    boolean hasResults();
    /**
     * <code>optional bytes results = 6;</code>
     */
    com.google.protobuf.ByteString getResults();
  }
  /**
   * Protobuf type {@code MultiRPCMsg}
   */
  public  static final class MultiRPCMsg extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:MultiRPCMsg)
      MultiRPCMsgOrBuilder {
    // Use MultiRPCMsg.newBuilder() to construct.
    private MultiRPCMsg(com.google.protobuf.GeneratedMessage.Builder builder) {
      super(builder);
    }
    private MultiRPCMsg() {
      msgType_ = 0;
      reqID_ = 0;
      serviceName_ = "";
      methodID_ = 0;
      args_ = com.google.protobuf.ByteString.EMPTY;
      results_ = com.google.protobuf.ByteString.EMPTY;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private MultiRPCMsg(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry) {
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
              int rawValue = input.readEnum();
              MultiRPCProto.MultiRPCMsg.MsgType value = MultiRPCProto.MultiRPCMsg.MsgType.valueOf(rawValue);
              if (value == null) {
                unknownFields.mergeVarintField(1, rawValue);
              } else {
                bitField0_ |= 0x00000001;
                msgType_ = rawValue;
              }
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              reqID_ = input.readUInt32();
              break;
            }
            case 26: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000004;
              serviceName_ = bs;
              break;
            }
            case 32: {
              bitField0_ |= 0x00000008;
              methodID_ = input.readUInt32();
              break;
            }
            case 42: {
              bitField0_ |= 0x00000010;
              args_ = input.readBytes();
              break;
            }
            case 50: {
              bitField0_ |= 0x00000020;
              results_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw new RuntimeException(e.setUnfinishedMessage(this));
      } catch (java.io.IOException e) {
        throw new RuntimeException(
            new com.google.protobuf.InvalidProtocolBufferException(
                e.getMessage()).setUnfinishedMessage(this));
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MultiRPCProto.internal_static_MultiRPCMsg_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MultiRPCProto.internal_static_MultiRPCMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              MultiRPCProto.MultiRPCMsg.class, MultiRPCProto.MultiRPCMsg.Builder.class);
    }

    /**
     * Protobuf enum {@code MultiRPCMsg.MsgType}
     */
    public enum MsgType
        implements com.google.protobuf.ProtocolMessageEnum {
      /**
       * <code>REQ = 0;</code>
       */
      REQ(0, 0),
      /**
       * <code>RESP = 1;</code>
       */
      RESP(1, 1),
      ;

      /**
       * <code>REQ = 0;</code>
       */
      public static final int REQ_VALUE = 0;
      /**
       * <code>RESP = 1;</code>
       */
      public static final int RESP_VALUE = 1;


      public final int getNumber() {
        return value;
      }

      public static MsgType valueOf(int value) {
        switch (value) {
          case 0: return REQ;
          case 1: return RESP;
          default: return null;
        }
      }

      public static com.google.protobuf.Internal.EnumLiteMap<MsgType>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static com.google.protobuf.Internal.EnumLiteMap<MsgType>
          internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<MsgType>() {
              public MsgType findValueByNumber(int number) {
                return MsgType.valueOf(number);
              }
            };

      public final com.google.protobuf.Descriptors.EnumValueDescriptor
          getValueDescriptor() {
        return getDescriptor().getValues().get(index);
      }
      public final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }
      public static final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptor() {
        return MultiRPCProto.MultiRPCMsg.getDescriptor().getEnumTypes().get(0);
      }

      private static final MsgType[] VALUES = values();

      public static MsgType valueOf(
          com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "EnumValueDescriptor is not for this type.");
        }
        return VALUES[desc.getIndex()];
      }

      private final int index;
      private final int value;

      private MsgType(int index, int value) {
        this.index = index;
        this.value = value;
      }

      // @@protoc_insertion_point(enum_scope:MultiRPCMsg.MsgType)
    }

    private int bitField0_;
    public static final int MSGTYPE_FIELD_NUMBER = 1;
    private int msgType_;
    /**
     * <code>required .MultiRPCMsg.MsgType msgType = 1;</code>
     */
    public boolean hasMsgType() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required .MultiRPCMsg.MsgType msgType = 1;</code>
     */
    public MultiRPCProto.MultiRPCMsg.MsgType getMsgType() {
      MultiRPCProto.MultiRPCMsg.MsgType result = MultiRPCProto.MultiRPCMsg.MsgType.valueOf(msgType_);
      return result == null ? MultiRPCProto.MultiRPCMsg.MsgType.REQ : result;
    }

    public static final int REQID_FIELD_NUMBER = 2;
    private int reqID_;
    /**
     * <code>required uint32 reqID = 2;</code>
     */
    public boolean hasReqID() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required uint32 reqID = 2;</code>
     */
    public int getReqID() {
      return reqID_;
    }

    public static final int SERVICENAME_FIELD_NUMBER = 3;
    private volatile java.lang.Object serviceName_;
    /**
     * <code>optional string serviceName = 3;</code>
     */
    public boolean hasServiceName() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional string serviceName = 3;</code>
     */
    public java.lang.String getServiceName() {
      java.lang.Object ref = serviceName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          serviceName_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string serviceName = 3;</code>
     */
    public com.google.protobuf.ByteString
        getServiceNameBytes() {
      java.lang.Object ref = serviceName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        serviceName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int METHODID_FIELD_NUMBER = 4;
    private int methodID_;
    /**
     * <code>optional uint32 methodID = 4;</code>
     */
    public boolean hasMethodID() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional uint32 methodID = 4;</code>
     */
    public int getMethodID() {
      return methodID_;
    }

    public static final int ARGS_FIELD_NUMBER = 5;
    private com.google.protobuf.ByteString args_;
    /**
     * <code>optional bytes args = 5;</code>
     */
    public boolean hasArgs() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional bytes args = 5;</code>
     */
    public com.google.protobuf.ByteString getArgs() {
      return args_;
    }

    public static final int RESULTS_FIELD_NUMBER = 6;
    private com.google.protobuf.ByteString results_;
    /**
     * <code>optional bytes results = 6;</code>
     */
    public boolean hasResults() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <code>optional bytes results = 6;</code>
     */
    public com.google.protobuf.ByteString getResults() {
      return results_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasMsgType()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasReqID()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeEnum(1, msgType_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeUInt32(2, reqID_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBytes(3, getServiceNameBytes());
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeUInt32(4, methodID_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeBytes(5, args_);
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        output.writeBytes(6, results_);
      }
      unknownFields.writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, msgType_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(2, reqID_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, getServiceNameBytes());
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(4, methodID_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(5, args_);
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(6, results_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    public static MultiRPCProto.MultiRPCMsg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MultiRPCProto.MultiRPCMsg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MultiRPCProto.MultiRPCMsg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MultiRPCProto.MultiRPCMsg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MultiRPCProto.MultiRPCMsg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static MultiRPCProto.MultiRPCMsg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static MultiRPCProto.MultiRPCMsg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static MultiRPCProto.MultiRPCMsg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static MultiRPCProto.MultiRPCMsg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static MultiRPCProto.MultiRPCMsg parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(MultiRPCProto.MultiRPCMsg prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code MultiRPCMsg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:MultiRPCMsg)
        MultiRPCProto.MultiRPCMsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return MultiRPCProto.internal_static_MultiRPCMsg_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return MultiRPCProto.internal_static_MultiRPCMsg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                MultiRPCProto.MultiRPCMsg.class, MultiRPCProto.MultiRPCMsg.Builder.class);
      }

      // Construct using MultiRPCProto.MultiRPCMsg.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        msgType_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        reqID_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        serviceName_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        methodID_ = 0;
        bitField0_ = (bitField0_ & ~0x00000008);
        args_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000010);
        results_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000020);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return MultiRPCProto.internal_static_MultiRPCMsg_descriptor;
      }

      public MultiRPCProto.MultiRPCMsg getDefaultInstanceForType() {
        return MultiRPCProto.MultiRPCMsg.getDefaultInstance();
      }

      public MultiRPCProto.MultiRPCMsg build() {
        MultiRPCProto.MultiRPCMsg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public MultiRPCProto.MultiRPCMsg buildPartial() {
        MultiRPCProto.MultiRPCMsg result = new MultiRPCProto.MultiRPCMsg(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.msgType_ = msgType_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.reqID_ = reqID_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.serviceName_ = serviceName_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.methodID_ = methodID_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.args_ = args_;
        if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
          to_bitField0_ |= 0x00000020;
        }
        result.results_ = results_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof MultiRPCProto.MultiRPCMsg) {
          return mergeFrom((MultiRPCProto.MultiRPCMsg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(MultiRPCProto.MultiRPCMsg other) {
        if (other == MultiRPCProto.MultiRPCMsg.getDefaultInstance()) return this;
        if (other.hasMsgType()) {
          setMsgType(other.getMsgType());
        }
        if (other.hasReqID()) {
          setReqID(other.getReqID());
        }
        if (other.hasServiceName()) {
          bitField0_ |= 0x00000004;
          serviceName_ = other.serviceName_;
          onChanged();
        }
        if (other.hasMethodID()) {
          setMethodID(other.getMethodID());
        }
        if (other.hasArgs()) {
          setArgs(other.getArgs());
        }
        if (other.hasResults()) {
          setResults(other.getResults());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasMsgType()) {
          return false;
        }
        if (!hasReqID()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        MultiRPCProto.MultiRPCMsg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (MultiRPCProto.MultiRPCMsg) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int msgType_ = 0;
      /**
       * <code>required .MultiRPCMsg.MsgType msgType = 1;</code>
       */
      public boolean hasMsgType() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required .MultiRPCMsg.MsgType msgType = 1;</code>
       */
      public MultiRPCProto.MultiRPCMsg.MsgType getMsgType() {
        MultiRPCProto.MultiRPCMsg.MsgType result = MultiRPCProto.MultiRPCMsg.MsgType.valueOf(msgType_);
        return result == null ? MultiRPCProto.MultiRPCMsg.MsgType.REQ : result;
      }
      /**
       * <code>required .MultiRPCMsg.MsgType msgType = 1;</code>
       */
      public Builder setMsgType(MultiRPCProto.MultiRPCMsg.MsgType value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        msgType_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>required .MultiRPCMsg.MsgType msgType = 1;</code>
       */
      public Builder clearMsgType() {
        bitField0_ = (bitField0_ & ~0x00000001);
        msgType_ = 0;
        onChanged();
        return this;
      }

      private int reqID_ ;
      /**
       * <code>required uint32 reqID = 2;</code>
       */
      public boolean hasReqID() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required uint32 reqID = 2;</code>
       */
      public int getReqID() {
        return reqID_;
      }
      /**
       * <code>required uint32 reqID = 2;</code>
       */
      public Builder setReqID(int value) {
        bitField0_ |= 0x00000002;
        reqID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint32 reqID = 2;</code>
       */
      public Builder clearReqID() {
        bitField0_ = (bitField0_ & ~0x00000002);
        reqID_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object serviceName_ = "";
      /**
       * <code>optional string serviceName = 3;</code>
       */
      public boolean hasServiceName() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional string serviceName = 3;</code>
       */
      public java.lang.String getServiceName() {
        java.lang.Object ref = serviceName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            serviceName_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string serviceName = 3;</code>
       */
      public com.google.protobuf.ByteString
          getServiceNameBytes() {
        java.lang.Object ref = serviceName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          serviceName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string serviceName = 3;</code>
       */
      public Builder setServiceName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        serviceName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string serviceName = 3;</code>
       */
      public Builder clearServiceName() {
        bitField0_ = (bitField0_ & ~0x00000004);
        serviceName_ = getDefaultInstance().getServiceName();
        onChanged();
        return this;
      }
      /**
       * <code>optional string serviceName = 3;</code>
       */
      public Builder setServiceNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        serviceName_ = value;
        onChanged();
        return this;
      }

      private int methodID_ ;
      /**
       * <code>optional uint32 methodID = 4;</code>
       */
      public boolean hasMethodID() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>optional uint32 methodID = 4;</code>
       */
      public int getMethodID() {
        return methodID_;
      }
      /**
       * <code>optional uint32 methodID = 4;</code>
       */
      public Builder setMethodID(int value) {
        bitField0_ |= 0x00000008;
        methodID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional uint32 methodID = 4;</code>
       */
      public Builder clearMethodID() {
        bitField0_ = (bitField0_ & ~0x00000008);
        methodID_ = 0;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString args_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>optional bytes args = 5;</code>
       */
      public boolean hasArgs() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>optional bytes args = 5;</code>
       */
      public com.google.protobuf.ByteString getArgs() {
        return args_;
      }
      /**
       * <code>optional bytes args = 5;</code>
       */
      public Builder setArgs(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        args_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bytes args = 5;</code>
       */
      public Builder clearArgs() {
        bitField0_ = (bitField0_ & ~0x00000010);
        args_ = getDefaultInstance().getArgs();
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString results_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>optional bytes results = 6;</code>
       */
      public boolean hasResults() {
        return ((bitField0_ & 0x00000020) == 0x00000020);
      }
      /**
       * <code>optional bytes results = 6;</code>
       */
      public com.google.protobuf.ByteString getResults() {
        return results_;
      }
      /**
       * <code>optional bytes results = 6;</code>
       */
      public Builder setResults(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000020;
        results_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bytes results = 6;</code>
       */
      public Builder clearResults() {
        bitField0_ = (bitField0_ & ~0x00000020);
        results_ = getDefaultInstance().getResults();
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:MultiRPCMsg)
    }

    // @@protoc_insertion_point(class_scope:MultiRPCMsg)
    private static final MultiRPCProto.MultiRPCMsg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new MultiRPCProto.MultiRPCMsg();
    }

    public static MultiRPCProto.MultiRPCMsg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    public static final com.google.protobuf.Parser<MultiRPCMsg> PARSER =
        new com.google.protobuf.AbstractParser<MultiRPCMsg>() {
      public MultiRPCMsg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        try {
          return new MultiRPCMsg(input, extensionRegistry);
        } catch (RuntimeException e) {
          if (e.getCause() instanceof
              com.google.protobuf.InvalidProtocolBufferException) {
            throw (com.google.protobuf.InvalidProtocolBufferException)
                e.getCause();
          }
          throw e;
        }
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<MultiRPCMsg> getParserForType() {
      return PARSER;
    }

    public MultiRPCProto.MultiRPCMsg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_MultiRPCMsg_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_MultiRPCMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023multirpcProto.proto\"\247\001\n\013MultiRPCMsg\022%\n" +
      "\007msgType\030\001 \002(\0162\024.MultiRPCMsg.MsgType\022\r\n\005" +
      "reqID\030\002 \002(\r\022\023\n\013serviceName\030\003 \001(\t\022\020\n\010meth" +
      "odID\030\004 \001(\r\022\014\n\004args\030\005 \001(\014\022\017\n\007results\030\006 \001(" +
      "\014\"\034\n\007MsgType\022\007\n\003REQ\020\000\022\010\n\004RESP\020\001B\017B\rMulti" +
      "RPCProto"
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
    internal_static_MultiRPCMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_MultiRPCMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_MultiRPCMsg_descriptor,
        new java.lang.String[] { "MsgType", "ReqID", "ServiceName", "MethodID", "Args", "Results", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
