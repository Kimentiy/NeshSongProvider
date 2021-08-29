# NeshSongProvider

Отдельное приложение расширив которое можно предоставлять песни для плеера Nesh.

Для реализации своего провайдера необходимо:

1. Отнаследоваться от класса `SongProvider`. Наследник должен реализовать 2 метода: `getSong` и `onCreate`, наример:
```java
public class SongProviderImpl extends SongProvider {

    /**
     * Возвращает список песен
     *
     * query - ключевые слова в названии песен
     */
    @Override
    public List<Song> getSongs(String query) {
        return null;
    }

    /**
     * Метод для инициализации провайдера
     *
     * @return true если провайдер был инициализировал
     */
    @Override
    public boolean onCreate() {
        return false;
    }
}
```

ВНИМАНИЕ!!!
Методы `getSong` и `onCreate` вызываются из UI потока, поэтому делать запрос в сеть из них нельзя.

2. Отредактировать объявление провайдера в `AndroidManifest.xml`. В атрибуте `name` должен быть указан класс расширяющий провайдер.
В атрибуте `authorities` должен быть указан URI на который будет реагировать провайдер. URI должен состоять из `com.nesh.songprovider` и уникального идентификатора провайдера, к примеру `.mysuperprovider`.
Пример:
```xml
<provider
    android:name=".SongProviderImpl"
    android:authorities="com.nesh.songprovider.myproviderimpl"
    android:exported="true"
    android:grantUriPermissions="true" />
```

3. Если планируется использование интернета, то необходимо добавить разрешение на сеть в `AndroidManifest.xml`.
```xml
<uses-permission android:name="android.permission.INTERNET" />

<application ... </application>
```
