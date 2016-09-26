Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.stackexchange.com")
				.addConverterFactory(GsonConverterFactory.create())
				.build();

StackOverflowAPI stackOverflowAPI = retrofit.create(StackOverflowAPI.class);
		

Call<StackOverflowQuestions> call = getAPI().loadQuestions("android");
call.enqueue(new Callback<StackOverflowQuestions>() {
	@Override
	public void onResponse(Call<StackOverflowQuestions> call, Response<StackOverflowQuestions> response) {
		ArrayAdapter<Question> adapter = (ArrayAdapter<Question>) listView.getAdapter();
		adapter.clear();
		adapter.addAll(response.body().items);
	}
	
	@Override
	public void onFailure(Call<StackOverflowQuestions> call, Throwable t) {
		// falha
	}
});
