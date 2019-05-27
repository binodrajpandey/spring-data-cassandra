/// **To change this license header,choose License Headers in Project Properties.*To change this
/// template file,choose Tools|Templates*and open the template in the editor.*/package
/// com.goldenhandshake.demo;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
// import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
// import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
// import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
//
/// ****
//
// @author binod
// */
// @Configuration
// @EnableCassandraRepositories
// public class CassandraConfig extends AbstractCassandraConfiguration{
// @Autowired
// private CassandraConfigProperties cassandraConfigProperties;
//
// @Override
// protected String getKeyspaceName() {
// return cassandraConfigProperties.getKeyspaceName();
// }
// @Bean
// public CassandraClusterFactoryBean cluster() {
// CassandraClusterFactoryBean cluster =
// new CassandraClusterFactoryBean();
// cluster.setContactPoints(cassandraConfigProperties.getContactPoint());
// cluster.setPort(cassandraConfigProperties.getPort());
// cluster.setUsername(cassandraConfigProperties.getUsername());
// cluster.setPassword(cassandraConfigProperties.getPassword());
// return cluster;
// }
// @Bean
// public CassandraMappingContext cassandraMapping() throws ClassNotFoundException{
// return new CassandraMappingContext();
// }
// }
