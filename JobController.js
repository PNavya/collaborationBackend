/**
 * 
 */
'use strict';

app.controller('JobController', [
		'$scope',
		'JobService',
		'$location',
		'$rootScope',
		function($scope, JobService, $location, $rootScope) {
			console.log("JobController...")
			var self = this; // self is alias name instead directly use this
			self.job = { // initialization
				jobid : '',
				user_id:'',
				job_title : '',
				company : '',
				DescriptionS : '',
				Dateofcreation : '',
				Dateofexpiry:'',
				status : '',
				errorCode:'',
				errorMessage:''
			};
			self.jobs = [];
			
			/*APPLY FOR JOB*/
			
			self.applyForJob=applyForJob
			
			function applyForJob(jobid){
				var currentUser=$rootScope.currentUser
				if(typeof currentUser=='undefined')
					{
					alert("Please login to apply for job")
					console.log("User not logged in.Cannot apply")
					$location.path('/login');
			}
			JobService
			.applyForJob(jobid)
			.then(
					function(d){
						self.job=d;
						alert("You have successfully applied for job")
					},
					function(errResponse){
						console.error('Error while applying')
					});
		}		
			/*GET SELECTED JOB DETAILS*/

			self.getSelectedJob = getJob

			function getJob(jobid) {
				console.log("getting job! " + jobid)
				JobService.getJob(job_id).then(function(d) {
					self.job = d;
					$location.path('/view_job');
				}, function(errResponse) {
					console.error('Error while fetching jobs');
				});
			};

			/* GET LIST OF ALL JOBS */

			self.fetchAllJobs = function() {
				JobService.fetchAllJobs()
				.then(function(d) { // these methods
																// are called
																// call back
																// methods
					self.jobs = d;
				}, function(errResponse) {
					console.error('Error while fetching Jobs');
				});
			};
			self.fetchAllJobs();

			/* CREATE A JOB */

			self.createJob = function(job) {
				console.log('submit a new job',self.job);
				JobService.createJob(job)
				.then(function(d){
				   self.job=d;	
				},
				function(errResponse) {
							console.error('Error while creating Jobs');
						});
			};

			/* UPDATE A JOB */

			self.updateJob = function(job) {
				JobService.updateJob(job).then(self.fetchAllJobs,
						function(errResponse) {
							console.error('Error while updating Jobs');
						});
			};	

			
			/* GET MY APPLIED JOBS*/
			
			self.getMyAppliedJobs = function(){
				console.log('calling the method getMyAppliedJobs');
				JobService.getMyAppliedJobs().then(function(d){
					self.jobs=d;
					/*$location.path('list_job'); */
				},function(errResponse) {
					console.error('Error while applying Job');
				});
	};
	
	/* REJECT JOB APPLICATION */
	
	self.rejectJobApplication = function(userid){
		console.log('calling rejectJobApplication');
		JobService.rejectJobApplication().then(function(d){
			self.jobs=d;
		},function(errResponse) {
			console.error('Error while applying Job');
		});
};
		
/* SELECT A CANDIDATE */

self.selectUser = function(userid) {
	console.log('Calling selectUser method:',userid);
	JobService.selectUser(userid,selectedJobid)
	.then(function(d){
		self.job=d;
		alert('Application status changed to selected')
	},function(errResponse) {
		console.error('Error while selecting candidate');
	});
};

self.submit = function() {
	if (self.job.jobid == null) {
		console.log('Saving New Job', self.job);
		//self.job.user_name = $rootScope.currentUser.user_id
		self.createjob(self.job);
	}
	self.reset();
};

self.reset=function(){
	console.log('submit a new job',self.job);
	self.job={
			jobid : '',
			user_id:'',
			job_title : '',
			company : '',
			DescriptionS : '',
			Dateofcreation : '',
			Dateofexpiry:'',
			status : '',
			errorCode:'',
			errorMessage:''
		};
     $scope.myForm.$setPristine(); //reset Form


			/* END OF ALL */
};
	
		} ]);