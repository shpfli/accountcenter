package pers.hubery.accountcenter;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * sharding sql generator
 *
 * @author LiPengfei
 * @version ShardingSqlGenerator.java v1.0 2022-03-22 10:37
 */
public class ShardingSqlGenerator {

    private static final int SHARDING_INDEX_LENGTH = 2;
    private static final int SHARD_COUNT           = 10;

    public static void main(String[] args) throws IOException {

        String template = "templates/tmp.sql";

        // 读模板内容
        InputStream in = ClassLoader.getSystemResourceAsStream(template);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }

        // 模板内容
        String content = sb.toString();

        // 生成sql
        List<String> sqlList = generate(SHARD_COUNT, SHARDING_INDEX_LENGTH, content);

        // 输出
        for (String sql : sqlList) {
            System.out.println(sql);
        }
    }

    /**
     * 真正的根据输入生成sql
     *
     * @param shardCount          分片数
     * @param shardingIndexLength 分片索引长度，不足前面补0
     * @param sqlTemplate         sql模板
     * @return sql列表
     */
    private static List<String> generate(int shardCount, int shardingIndexLength, String sqlTemplate) {

        List<String> results = new ArrayList<>(shardCount);

        //System.out.println("模板文件：" + sqlTemplate);

        if (!sqlTemplate.contains("${")) {
            System.out.println("\n* Template does not contains ${}, please check the syntax. Exit 1");
            System.exit(1);
        }

        // 初始化模板引擎
        VelocityEngine engine = new VelocityEngine();
        VelocityContext context = new VelocityContext();
        engine.setProperty(Velocity.INPUT_ENCODING, StandardCharsets.UTF_8.name());

        for (int i = 0; i < shardCount; i++) {
            context.put("shardingIndex", String.format("%0" + shardingIndexLength + "d", i));
            StringWriter writer = new StringWriter();
            engine.evaluate(context, writer, "sql-template", sqlTemplate);
            results.add(writer.toString());
        }
        return results;
    }

}
