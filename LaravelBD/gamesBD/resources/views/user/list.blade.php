@extends('layouts.app')

@section('content')
@if (Route::has('login'))
@auth
    <div class="card-header">{{ __('Utilizadores') }}</div>
    <div class="col-lg-1">
    </div>
    <div class="card-body">
        @if (session('status'))
            <div class="alert alert-success" role="alert">
                {{ session('status') }}
            </div>
        @endif
        <div class="col-lg-1">
            <a class="btn btn-success" href="{{ route('user.create') }}">Add</a>
        </div>
        <table class="table table-bordered">
            <tr>
                <th>Id</th>
                <th>Email</th>
                <th>Password</th>
                <th>Operações</th>
            </tr>
            @php
                $i = 0;
            @endphp
            @foreach ($user as $user)
                <tr>
                    <td>{{ ++$i }}</td>
                    <td>{{ $user->email }}</td>
                    <td>{{ $user->password }}</td>
                    <td>
                        <form action="{{ route('user.destroy',$user->id) }}" method="POST">
                            <a class="btn btn-info" href="{{ route('user.show',$user->id) }}">Show</a>
                            <a class="btn btn-primary" href="{{ route('user.edit',$user->id) }}">Edit</a>
                            @csrf
                            @method('DELETE')
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </td>
                </tr>
            @endforeach
        </table>
    </div>

    <div class="hidden fixed top-0 right-0 px-6 py-4 sm:block">
        <a href="{{ url('/home') }}" class="text-sm text-gray-700 dark:text-gray-500 underline">Home</a>
    @else
        <a href="{{ route('login') }}" class="text-sm text-gray-700 dark:text-gray-500 underline">Log in</a>
    @endauth
</div>
    @endif
@endsection
