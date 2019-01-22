package zut.cs.network.bean;

/**
 * 与消息表对应的实体类
 *
 */

 
public class Message {
	/**
     * 主键
     */
    public String id;
    /**
     * 指令名称
     */
    public String command;
    /**
     * 描述
     */
    public String description;
   /*   
     *内容
    */ 
    public String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
	
}
