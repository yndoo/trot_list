[벨로그에서 보기](https://velog.io/@kuronuma_daisy/Android-%ED%8A%B8%EB%A1%AF-%EA%B0%80%EC%88%98%EB%B3%84-%EB%85%B8%EB%9E%98-%EB%A6%AC%EC%8A%A4%ED%8A%B8-%EC%95%B1-Navigation-Fragment-Recyclerview-%ED%99%9C%EC%9A%A9)

Navigation 기능과 Recyclerview를 복습해보는 애플리케이션이었다. Navigation은 Fragment를 활용해 제작했다. 기록하다보면 내 머리에 조금이라도 더 남고 나중에도 꺼내볼 수 있겠지! 기초를 다시 배우고 있다보니 기록과 복습이 소중한 요즘이다.

# 완성 모습
네비게이션으로 이동하여 각 가수의 노래 리스트를 보여주는 애플리케이션이다.
![](https://velog.velcdn.com/images/kuronuma_daisy/post/e31767eb-e468-42b2-b93d-76f7e7aba55b/image.gif)

# Navigation 사용 방법
### 1. Navigation 리소스 파일 생성
Resource type이 Navigation인 리소스 파일을 만든다. 이름은 마음대로, 여기서는 trot_nav이다.
![](https://velog.velcdn.com/images/kuronuma_daisy/post/41a4a504-1fea-4a46-8dc8-f5a696e14575/image.png)
### 2. Navigation - 프래그먼트 연결
Navigation과 각 프래그먼트들을 보여줄 액티비티의 xml파일에 NavHostFragment를 추가한다.
여기서는 activity_main.xml이다
![](https://velog.velcdn.com/images/kuronuma_daisy/post/b7773adf-3efb-495c-926a-ca69c6190e30/image.png)
1에서 만든 trot_nav를 연결해준다.
![](https://velog.velcdn.com/images/kuronuma_daisy/post/5d9ab8a3-e691-4b93-a401-0b69d92b25d0/image.png)

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/fragmentContainerView"
        android:name="androidx.navigation.fragment.NavHostFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:defaultNavHost="true"
        app:navGraph="@navigation/trot_nav"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
### 3. 프래그먼트 생성 및 action 연결
빈 프래그먼트를 필요한만큼 생성한다. (Navigation의 버튼? 수만큼)
![](https://velog.velcdn.com/images/kuronuma_daisy/post/84e1841e-64d8-4b7f-aa60-26cf480e443e/image.png)

trot_nav.xml에서 프래그먼트간의 이동 action을 추가해준다. 예시에서는 세 개의 프래그먼트를 생성해 서로서로 연결해줬다. 총 6개의 action이 생성된다. 아래 코드에서 `action` 태그에 해당한다.  

사진에 singer1Fragment 앞에 집 모양의 아이콘이 있는데, 이는 가장 먼저 보일 프래그먼트를 의미한다.
![](https://velog.velcdn.com/images/kuronuma_daisy/post/17190b08-b6bc-4888-a8db-b98a3de57fbb/image.png)
```xml
<?xml version="1.0" encoding="utf-8"?>
<navigation
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/trot_nav"
    app:startDestination="@id/singer1Fragment">
    <fragment
        android:id="@+id/singer1Fragment"
        android:name="com.yndoo.trot_list.Singer1Fragment"
        android:label="fragment_singer1"
        tools:layout="@layout/fragment_singer1" >
        <action
            android:id="@+id/action_singer1Fragment_to_singer2Fragment"
            app:destination="@id/singer2Fragment" />
        <action
            android:id="@+id/action_singer1Fragment_to_singer3Fragment"
            app:destination="@id/singer3Fragment" />
    </fragment>
    <fragment
        android:id="@+id/singer2Fragment"
        android:name="com.yndoo.trot_list.Singer2Fragment"
        android:label="fragment_singer2"
        tools:layout="@layout/fragment_singer2" >
        <action
            android:id="@+id/action_singer2Fragment_to_singer3Fragment"
            app:destination="@id/singer3Fragment" />
        <action
            android:id="@+id/action_singer2Fragment_to_singer1Fragment"
            app:destination="@id/singer1Fragment" />
    </fragment>
    <fragment
        android:id="@+id/singer3Fragment"
        android:name="com.yndoo.trot_list.Singer3Fragment"
        android:label="fragment_singer3"
        tools:layout="@layout/fragment_singer3" >
        <action
            android:id="@+id/action_singer3Fragment_to_singer1Fragment"
            app:destination="@id/singer1Fragment" />
        <action
            android:id="@+id/action_singer3Fragment_to_singer2Fragment"
            app:destination="@id/singer2Fragment" />
    </fragment>
</navigation>
```
### 4. 프래그먼트.kt에서 Navigation과 action 연결
처음에 프래그먼트(Fragment) 생성하면 뭐가 많이 써있는데 필요없는 건 모두 지우면 된다.
Navigation의 메뉴(?)를 클릭하면 id로 대상 action을 찾아 이동한다. `findNavController().navigate()`을 이용한다.

다음 예시는 Singer1Fragment.kt 코드이다. Singer2Fragment.kt, Singer3Fragment.kt 에서도 ImageView와 action의 id를 바꿔가며 복붙해주면 된다.
```kotlin
package com.yndoo.trot_list

import ...

class Singer1Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_singer1, container, false)

        //view.findViewById<ImageView>(R.id.img2).setOnClickListener {  }로 해도 됨
        val img2 = view.findViewById<ImageView>(R.id.img2)
        val img3 = view.findViewById<ImageView>(R.id.img3)
		
        // 이미지 클릭 시 Navigation에 만들어놨던 방향대로 action을 행함
        img2.setOnClickListener {
            it.findNavController().navigate(R.id.action_singer1Fragment_to_singer2Fragment)
        }
        img3.setOnClickListener {
            it.findNavController().navigate(R.id.action_singer1Fragment_to_singer3Fragment)
        }
        return view
    }
}
```
