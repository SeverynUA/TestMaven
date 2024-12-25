package brainacad.org;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Random;

public class TestDb
{
    public static void main(String[] arg) throws SQLException, IOException
    {
        CreateTable();
        Init();
        Info();
        Update();
        Delete();

        Info();
    }

    public static void CreateTable() throws IOException, SQLException
    {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1234567890";

        String filePath = "init-db.sql";

        try (Connection connection = DriverManager.getConnection(url, user, password))
        {
            System.out.println("Соединение с БД установлено!");

            String sql = new String(Files.readAllBytes(Paths.get(filePath)));

            try (Statement statement = connection.createStatement())
            {
                statement.execute(sql);
                System.out.println("База данных успешно инициализирована!");
            } catch (SQLException e) {
                System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
            }
        } catch (SQLException | IOException e) {
            System.err.println("Ошибка подключения или чтения файла: " + e.getMessage());
        }
    }

    public static void Init() throws IOException, SQLException
    {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1234567890";

        String[] types = {"INFO", "WARN"};

        try (Connection connection = DriverManager.getConnection(url, user, password))
        {
            System.out.println("Соединение с БД установлено!");

            String insertQuery = "INSERT INTO notice (message, type, processed) VALUES (?, ?, ?)";

            while (true) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery))
                {
                    Random random = new Random();
                    String type = types[random.nextInt(types.length)];
                    String message;

                    if ("INFO".equals(type))
                    {
                        message = "Новое сообщение от " + LocalDateTime.now();
                    } else {
                        message = "Произошла ошибка в " + LocalDateTime.now();
                    }

                    preparedStatement.setString(1, message);
                    preparedStatement.setString(2, type);
                    preparedStatement.setBoolean(3, false);

                    preparedStatement.executeUpdate();
                    System.out.println("Сообщение добавлено: " + message);

                    Thread.sleep(1000);

                } catch (SQLException e) {
                    System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
                } catch (InterruptedException e) {
                    System.err.println("Ошибка во время паузы: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка подключения к базе данных: " + e.getMessage());
        }
    }

    public static void Info() throws IOException, SQLException
    {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1234567890";

        try (Connection connection = DriverManager.getConnection(url, user, password))
        {
            System.out.println("Соединение с БД установлено!");


            String selectQuery = "SELECT message, type, processed FROM notice";

            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(selectQuery);

                System.out.println("Список сообщений:");
                while (resultSet.next()) {
                    String message = resultSet.getString("message");
                    String type = resultSet.getString("type");
                    boolean processed = resultSet.getBoolean("processed");

                    System.out.println("Сообщение: " + message);
                    System.out.println("Тип: " + type);
                    System.out.println("Обработано: " + processed);
                    System.out.println("--------------");
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Ошибка подключения к базе данных: " + e.getMessage());
        }
    }

    public static void Update() throws IOException, SQLException
    {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1234567890";

        try
        {
            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(url, user, password))
            {
                System.out.println("Підключення успішне!");


                String updateQuery = "UPDATE notice SET processed = ? WHERE type = ?";
                try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery))
                {
                    updateStatement.setBoolean(1, true);
                    updateStatement.setString(2, "INFO");

                    int updatedRows = updateStatement.executeUpdate();
                    System.out.println("Оновлено рядків: " + updatedRows);
                } catch (SQLException e) {
                    System.err.println("Помилка при оновленні запису: " + e.getMessage());
                }

            }
        } catch (ClassNotFoundException e) {
            System.err.println("Драйвер PostgreSQL не знайдено: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Помилка підключення: " + e.getMessage());
        }
    }

    public static void Delete() throws IOException, SQLException
    {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1234567890";

        try
        {
            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(url, user, password))
            {
                System.out.println("Підключення успішне!");

                String deleteQuery = "DELETE FROM notice WHERE type = ?";

                try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery))
                {
                    deleteStatement.setString(1, "WARN");

                    int rowsAffected = deleteStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Запис видалений");
                    } else {
                        System.out.println("Запис не знайдено для видалення");
                    }
                } catch (SQLException e) {
                    System.err.println("Помилка при видаленні запису: " + e.getMessage());
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Драйвер PostgreSQL не знайдено: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Помилка підключення: " + e.getMessage());
        }
    }
}
